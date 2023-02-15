package data_Structures.SkipListImpl;

import java.util.Random;

/**
 * @BelongsPackage: data_Structures.SkipListImpl
 * @Author: yca
 * @CreateTime: 2023-01-16  17:07
 * @Description:
 *          层级使用数组实现的跳表
 *          K 只有继承了Comparable这个接口的类才能使用
 */
public class SkipListArray<K extends Comparable<K>, V> implements SkipList<K, V> {

    // 头节点
    private final Node<K, V> head;
    // 最大支持的层数
    private final static int MaxLevel = 1 << 4;
    // 当前的最大层数
    private int highLevel;
    // 每一层的节点数
    private final int[] size = new int[MaxLevel];

    public SkipListArray() {
        this.head = new Node<>();
        this.highLevel = MaxLevel;
    }

    public SkipListArray(K key, V value){
        this.head = new Node<>();
        this.highLevel = MaxLevel;
        insert(key, value);
    }

    public SkipListArray(int highLevel) {
        this.head = new Node<>();
        this.highLevel = highLevel;
    }

    static class Node<K extends Comparable<K>,V>{
        K key;
        V value;
        Node<K, V>[] next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }

        public Node(K key, V value, int level) {
            if (key == null || value == null)
                throw new IllegalArgumentException("Key and Value can not be null");
            this.key = key;
            this.value = value;
            this.next = new Node[level];
        }

        public Node() {
            this.next = new Node[MaxLevel];
        }
        // 调用实现的compareTo函数进行值的比较
        public int compareKey(K k1){
            return this.key.compareTo(k1);
        }
    }
    @Override
    public V search(K key) {
        if (key == null)throw new IllegalArgumentException("key can not be null");
        Node<K, V> pre = head;
        Node<K, V> cur = head.next[highLevel - 1];
        // 从上往下找
        for (int curLevel = highLevel - 1; curLevel >= 0; curLevel--) {
            if (cur == head)cur = head.next[curLevel];
            while (cur != null && cur.key.compareTo(key) < 0){
                pre = cur;
                cur = cur.next[curLevel];
            }
            if (cur == null || cur.key.compareTo(key) > 0){
                cur = pre;
                continue;
            }
            if (cur.key.compareTo(key) == 0){
                return cur.value;
            }
        }
        return null;
    }

    @Override
    public boolean exist(K key, V value) {
        if (key == null || value == null)
            throw new IllegalArgumentException("key and value can not be null");
        return search(key) != null && search(key).equals(value);
    }
    @Override
    public boolean exist(K key){
        if (key == null)
            throw new IllegalArgumentException("key can not be null");
        return search(key) != null;
    }

    @Override
    public boolean update(K key, V value) {
        // 获取前驱节点数组
        Node<K, V>[] preNodes = findPreNodes(key);
        // 判断前驱节点数组中每个节点的下个节点是不是需要更新的那个节点
        // 从上到下
        boolean flag = false;
        for(int i = preNodes.length - 1; i >= 0; i--){
            if (preNodes[i].next[i] != null &&
                    preNodes[i].next[i].key.compareTo(key) == 0){
                preNodes[i].next[i].value = value;// 更新Value值
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean delete(K key) {
        // 获取前驱节点数组
        Node<K, V>[] preNodes = findPreNodes(key);
        boolean flag = false;
        for (int i = preNodes.length - 1; i >= 0; i--){
            if (preNodes[i].next[i] != null &&
                    preNodes[i].next[i].key.compareTo(key) == 0){
                preNodes[i].next[i] = preNodes[i].next[i].next[i];
                this.size[i]--;
                flag = true;
                if (this.head.next[i] == null)this.highLevel--;
            }
        }
        return flag;
    }


    @Override
    public void insert(K key, V value) {
        if (key == null || value == null){
            throw new IllegalArgumentException("key and value can not be null");
        }
        // 先生成该节点的层数大小
        int level = randomLevel();
        // 判断要插入节点的key在skipList中是否存在，存在则立刻返回
        if (exist(key))return;
        // 找到要插入节点的各层的前驱节点
        Node<K, V>[] preNodes = findPreNodes(key);
        // 插入节点，安排好插入节点的前驱和后驱关系
        // 生成一个新的node来插入
        Node<K, V> newNode = new Node<>(key, value, level);
        int l = level;
        // 对于level比highLevel高的节点另作处理并更新最大level
        if (level > highLevel){
            for (; l >= highLevel; l--) {
                this.head.next[l] = newNode;
                this.size[l]++;
            }
            this.highLevel = level;
            l++;
        }
        // 从小到大正常插入在前驱节点的后面
        for (int i = 0; i < l; i++) {
            // 处理新节点的后驱
            newNode.next[i] = preNodes[i].next[i];
            // 处理新节点的前驱
            preNodes[i].next[i] = newNode;
            // 增加该层节点的数量
            this.size[i]++;
        }

    }


    /**
     * 找到寻找key的所有前驱节点，形成一个数组进行返回
     * @param key K key
     * @return 数组，大小为当前skipList的highLevel
     */
    public Node<K, V>[] findPreNodes(K key){
        Node<K, V>[] preNodes = new Node[this.highLevel];
        Node<K, V> pre = head;
        Node<K, V> cur = head;
        // 从高层找到底层
        for (int curLevel = this.highLevel - 1; curLevel >= 0; curLevel--) {
            while (cur.next[curLevel] != null && cur.next[curLevel].key.compareTo(key) < 0){
                pre = cur;
                cur = cur.next[curLevel];
            }
            preNodes[curLevel] = cur;
        }
        return preNodes;
    }
    @Override
    public int size(int level) {
        return this.size[level];
    }

    @Override
    public int size() {
        int sum = 0;
        for (int i = 0; i < MaxLevel; i++) {
            sum += this.size[i];
        }
        return sum;
    }

    /**
     * 随机生成一个节点的层数，最小为1，最大为Max_level
     * @return int level 层数
     */
    public int randomLevel(){
        int level = 1;
        Random random = new Random();
        while (random.nextBoolean()){
            if (level > MaxLevel)break;
            level++;
        }
        return level;
    }

    /**
     * 展示skipList的大体样子
     */
    @Override
    public void show(){
        System.out.println("-----------------------------------------------");
        for (int level = this.highLevel - 1; level >= 0; level--) {
            System.out.printf("level: %d\t", level);
            Node<K, V> q = this.head.next[level];
            while (null != q) {
                System.out.print("(" + q.key + "," + q.value + ")\t");
                q = q.next[level];
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------");
    }
}
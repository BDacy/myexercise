package data_Structures.SkipListImpl;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

/**
 * @BelongsPackage: data_Structures.SkipListImpl
 * @Author: yca
 * @CreateTime: 2023-02-15  14:37
 * @Description:
 *          SkipList跳表的实现，层级关系通过节点和节点指向的关系进行表示
 */
public class SkipListByNode<K extends Comparable<K>, V> implements SkipList<K, V> {

    SkipNode<K, V> head; // 头指针
    int highLevel; // 当前skipList的最大层级
    Random random; // 插入节点时，用来生成随机层数
    public final static int MAX_LEVEL = 1 << 4;// 允许的最大层数
    public int[] size = new int[MAX_LEVEL];

    public SkipListByNode(){
        this.random = new Random();
        highLevel = 1;
        head = new SkipNode<>();
    }

    /**
     * 初始化当前的level
     * @param level int
     */
    public SkipListByNode(int level){
        if (level <= 0 || level > MAX_LEVEL)
            throw new IllegalArgumentException("level should > 0 and < " + MAX_LEVEL);
        this.random = new Random();
        highLevel = level;
        head = new SkipNode<>();
        for (int i = 2; i <= highLevel; i++) {
            SkipNode<K, V> upHead = new SkipNode<>();
            upHead.down = head;
            head = upHead;
        }
    }

    @Override
    public V search(K key) {
        SkipNode<K, V> cur = head;
        while (cur != null){
            if (cur.right == null){
                cur = cur.down;
            }else if (cur.right.key.compareTo(key) < 0){
                cur = cur.right;
            }else if (cur.right.key.compareTo(key) == 0){
                return cur.right.value;
            }else {
                cur = cur.down;
            }
        }
        return null;
    }

    @Override
    public boolean exist(K key, V value) {
        if (key == null || value == null)
            throw new IllegalArgumentException("key and value can not be null");
        return search(key).equals(value);
    }

    @Override
    public boolean exist(K key) {
        if (key == null)
            throw new IllegalArgumentException("key can not be null");
        return search(key) != null;
    }

    @Override
    public boolean update(K key, V value) {
        if (key == null || value == null){
            throw new IllegalArgumentException("key and value can not be null");
        }
        SkipNode<K, V> cur = head;
        while (cur != null){
            if (cur.right == null){
                cur = cur.down;
            }else if (cur.right.key.compareTo(key) < 0){
                cur = cur.right;
            }else if (cur.right.key.compareTo(key) == 0){
                cur = cur.right;
                if (!cur.value.equals(value))
                    while (cur != null){
                        cur.value = value;
                        cur = cur.down;
                    }
                return true;
            }else {
                cur = cur.down;
            }
        }
        return false;
    }

    @Override
    public boolean delete(K key) {
        if (key == null)
            throw new IllegalArgumentException("key can not be null");
        SkipNode<K, V> cur = head;
        boolean flag = false;
        int curLevel = highLevel - 1;
        while (cur != null){
            if (cur.right == null) {
                cur = cur.down;
            }else if (cur.right.key.compareTo(key) == 0){
                cur.right = cur.right.right; // 找到节点并删除
                cur = cur.down; // 继续向下查找
                size[curLevel]--;
                flag = true;
            }else if (cur.right.key.compareTo(key) < 0){
                cur = cur.right;
                curLevel++;
            }else {
                cur = cur.down; // 后面没有了，向下查找
            }
            curLevel--;
        }
        return flag;
    }

    @Override
    public void insert(K key, V value) {
        if (key == null || value == null){
            throw new IllegalArgumentException("key and value can not be null");
        }
        // 待插入节点的层级高度
        int level = randomLevel();
        // 移动指针
        SkipNode<K, V> cur = head;
        // 用栈来存储前驱待插入的前驱节点
        Deque<SkipNode<K, V>> stack = new ArrayDeque<>();
        // 查找前驱节点
        while (cur != null){
            if (cur.right == null){
                stack.addLast(cur);// 记录一下可能的前驱节点
                cur = cur.down;// 右侧没了就向下
            }else if (cur.right.key.compareTo(key) > 0){
                stack.addLast(cur);
                cur = cur.down;
            }else if (cur.right.key.compareTo(key) == 0){
                // 发现已经有相同的key的节点了不需要再插入直接返回
                return;
            }else {
                cur = cur.right;
            }
        }

        int curLevel = 1;
        SkipNode<K, V> downNode = null; //记录可能的下方的节点
        while (!stack.isEmpty() && curLevel <= level){
            SkipNode<K, V> pre = stack.pollLast();
            SkipNode<K, V> newNode = new SkipNode<>(key, value);
            newNode.right = pre.right;
            pre.right = newNode;
            newNode.down = downNode;
            downNode = newNode;
            this.size[curLevel - 1]++;
            curLevel++;

            if (curLevel <= level && curLevel > highLevel){
                SkipNode<K, V> upHead = new SkipNode<>();
                upHead.down = head;
                head = upHead;
                stack.addLast(head);
                highLevel = curLevel;
            }
        }

    }

    @Override
    public int size(int level) {
        return size[level];
    }

    @Override
    public int size() {
        int sum = 0;
        for (int i = 0; i < highLevel; i++) {
            sum += size[i];
        }
        return sum;
    }

    @Override
    public void show() {
        SkipNode<K, V> teamNode=head;
        int index=1;
        SkipNode<K, V> last=teamNode;
        while (last.down!=null){
            last=last.down;
        }
        while (teamNode!=null) {
            SkipNode<K, V> enumNode=teamNode.right;
            SkipNode<K, V> enumLast=last.right;
            System.out.printf("%-8s","head->");
            while (enumLast!=null&&enumNode!=null) {
                if(enumLast.key.equals(enumNode.key))
                {
                    System.out.printf("%-12s",
                            "(" + enumLast.key + "," + enumLast.value + ")"
                                    + "->");
                    enumLast=enumLast.right;
                    enumNode=enumNode.right;
                }
                else{
                    enumLast=enumLast.right;
                    System.out.printf("%-12s","");
                }

            }
            teamNode=teamNode.down;
            index++;
            System.out.println();
        }
    }

    /**
     * 随机生成一个节点的层数，最小为1，最大为Max_level
     * @return int level 层数
     */
    public int randomLevel(){
        int level = 1;
        while (random.nextBoolean()){
            if (level >= MAX_LEVEL)break;
            level++;
        }
        return level;
    }

    static class SkipNode<K extends Comparable<K>, V> implements Serializable{
        K key;
        V value;
        SkipNode<K, V> right,down;// 指向右边和下边节点的指针
        public SkipNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        public SkipNode() {
        }
    }


    public int getHighLevel() {
        return highLevel;
    }

    /**
     * 将skipList当前的数据写入磁盘文件中，以kv键值对的形式,对象转换String对象写入
     * 如 delimiter = ":"时,存入数据为
     * 2:20
     * 3:30
     * @param filePath 文件路径
     * @param delimiter 分隔符
     */
    public void dump_file(String filePath, String delimiter){
        System.out.println("dump file now......");
        // 使用字符流，同时进行BufferedWriter封装FileWriter
        // 文件会覆盖
        try (FileWriter writer = new FileWriter(filePath);
             BufferedWriter bw = new BufferedWriter(writer)){
            // 获取在level 0 的head节点
            SkipNode<K, V> cur = head;
            while (cur.down != null)cur = cur.down;
            cur = cur.right;
            // 获取level 0 的所有节点，依次存入磁盘
            while (cur != null){
                bw.write(cur.key + delimiter + cur.value + "\n");
                cur = cur.right;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("complete!");
    }


    public void dump_object_file(String filePath){
        System.out.println("dump object file now......");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){
            // 获取在level 0 的head节点
            SkipNode<K, V> cur = head;
            while (cur.down != null)cur = cur.down;
            cur = cur.right;
            while (cur != null){
                oos.writeObject(cur.key);
                oos.writeObject(cur.value);
                cur = cur.right;
            }
            oos.writeObject(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("complete!");
    }

    public void load_object_file(String filePath){
        System.out.println("load_object_file now......");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))){
            K key;
            V value;
            SkipNode<K, V> node;
            while ((key = (K) ois.readObject()) != null
                    && (value = (V) ois.readObject()) != null){
                insert(key, value);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("complete!");
    }
//    /**
//     * 读取文件中的数据并构造skipList, 文件内容需要有效合法，参数需要指定分隔符
//     * 该函数只适用于K 为 Integer V 为 String 的情况
//     * @param filePath 文件路径
//     * @param delimiter 分隔符
//     */
//    public void load_file(String filePath, String delimiter){
//        System.out.println("loading file now......");
//        K key = null;
//        V value = null;
//        try (FileReader reader = new FileReader(filePath);
//            BufferedReader br = new BufferedReader(reader)){
//            String line;
//            while (!(line = br.readLine()).equals("")){
//                String[] split = line.split(delimiter);
//                if (split.length != 2)
//                    throw new IOException(line + " can read correctly to skipList");
//                insert(key,value);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("complete!");
//    }
}
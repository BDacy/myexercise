package data_Structures.SkipListImpl;

public interface SkipList<K,V> {
    /**
     * 根据key 寻找 value
     * @param key key
     * @return V value, 没有此值时返回null
     */
    public V search(K key);

    /**
     * 判断该键值对节点是否存在
     * @param key K
     * @param value V
     * @return 存在返回true, 否则返回false
     */
    public boolean exist(K key, V value);
    public boolean exist(K key);
    /**
     * 更新key 对应的值为 value
     * @param key  K key
     * @param value V value
     * @return 更新成功则为 true, 如果不存在该key对应的节点 则为 false
     */
    public boolean update(K key, V value);

    /**
     * 删除 key对应的节点
     * @param key K key
     * @return 存在该key的节点并且成功删除则返回true, 否则返回false
     */
    public boolean delete(K key);


    /**
     * 往跳表中插入数据
     * @param key K
     * @param value V
     */
    public void insert(K key, V value);


    /**
     * 第几层(level)的节点数
     * @param level int 层数
     * @return int 节点数
     */
    public int size(int level);

    /**
     * 所有节点，键值对的个数
     * @return int 键值对个数
     */
    public int size();

    public void show();
}

package data_Structures.SkipListTest;

import data_Structures.SkipListImpl.SkipList;
import data_Structures.SkipListImpl.SkipListByNode;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @BelongsPackage: data_Structures.SkipListTest
 * @Author: yca
 * @CreateTime: 2023-02-15  16:01
 * @Description:
 */
public class SkipListByNodeTest {
    @Test
    public void insertTest(){
        SkipList<Integer, String> skipList = new SkipListByNode<>();
//        skipList.insert(100, "100");
//        skipList.insert(200, "200");
//        skipList.insert(300, "300");
//        skipList.insert(400, "400");
//        skipList.insert(500, "500");
//        skipList.insert(600, "600");
        int[] num = new int[15];
        for (int i = 0; i < 15; i++) {
            int n = new Random().nextInt(100);
            num[i] = n;
            skipList.insert(n, "" + n);
        }
        skipList.show();
        System.out.println(Arrays.toString(num));
    }

    @Test
    public void deleteTest(){
        SkipListByNode<Integer, String> skipList = new SkipListByNode<>();
        skipList.insert(10, "10");
        skipList.insert(20, "20");
        skipList.insert(30, "30");
        skipList.insert(40, "40");
        skipList.insert(50, "50");
        skipList.insert(60, "60");
        System.out.println("删除前：");
        skipList.show();
        skipList.delete(10);
        skipList.delete(40);
        System.out.println("删除后：");
        skipList.show();
    }

    @Test
    public void updateTest(){
        SkipList<Integer, String> skipList = new SkipListByNode<>();
        skipList.insert(10, "10");
        skipList.insert(20, "20");
        skipList.insert(30, "30");
        skipList.insert(40, "40");
        skipList.insert(50, "50");
        skipList.insert(60, "60");
        skipList.show();
        assertTrue(skipList.update(20, "200"));
        assertTrue(skipList.update(40, "400"));
        assertFalse(skipList.update(0, "400"));
        System.out.println("修改后：");
        skipList.show();
    }

    @Test
    public void searchTest(){
        SkipListByNode<Integer, String> skipList = new SkipListByNode<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1e6; i++) {
            skipList.insert(i, "" + i);
        }
        long end = System.currentTimeMillis();
        System.out.println("插入时间："+ (end - start));
        System.out.println("插入的数据个数：" + skipList.size(0));
        for (int i = 0; i < skipList.getHighLevel(); i++) {
            System.out.println(i + "：" + skipList.size(i));
        }
        for (int i = 0; i < 1000; i++) {
            assertEquals(skipList.search(i), "" + i);
        }
//        skipList.show();
    }

    @Test
    public void existTest(){
        SkipList<Integer, String> skipList = new SkipListByNode<>();
        for (int i = 1000; i < 2000; i++) {
            skipList.insert(i, "" + i);
        }
        for (int i = 1000; i < 2000; i++) {
            assertTrue(skipList.exist(i));
        }
        skipList.show();
        assertEquals(skipList.size(0), 1000);
    }

    @Test
    public void randomLevelTest(){
        SkipListByNode<Integer, String> skipList = new SkipListByNode<>();
        for (int i = 0; i < 1e6; i++) {
            assertTrue(skipList.randomLevel() <= SkipListByNode.MAX_LEVEL);
        }
    }

    @Test
    public void dump_fileAndLoad_fileTest(){
        SkipListByNode<Integer, String> skipList = new SkipListByNode<>();
//        skipList.insert(1, "hello");
//        skipList.insert(2, "你好");
//        skipList.insert(4, "crazy now you know?");
//        skipList.insert(10, "crazy now you know?\\n");
//        skipList.insert(45, "30");
//        skipList.insert(45, "30");
//        skipList.insert(90, "30");
        // 插入数据
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1e6; i++) {
            skipList.insert(i, "" + i);
        }
        long end = System.currentTimeMillis();
        System.out.println("插入数据花费时间：" + (double)(end - start) / 1000 + "秒");

        // dump_String_file()
        start = System.currentTimeMillis();
//        skipList.show();
        skipList.dump_file("src/data_Structures/SkipListTest/dump_file", ":");
        end = System.currentTimeMillis();
        System.out.println("存入String数据到文件中花费时间为：" +  (double)(end - start) / 1000+ "秒");

        // dump_object_file()
        start = System.currentTimeMillis();
        skipList.dump_object_file("src/data_Structures/SkipListTest/dump_object_file");
        end = System.currentTimeMillis();
        System.out.println("存入object数据到文件中花费时间为：" +  (double)(end - start) / 1000 + "秒");

        // load_object_file()
        start = System.currentTimeMillis();
        SkipListByNode<Integer, String> list = new SkipListByNode<>();
        list.load_object_file("src/data_Structures/SkipListTest/dump_object_file");
        end = System.currentTimeMillis();
        System.out.println("读取object数据到skipList中花费时间为：" + (double)(end - start) / 1000 + "秒");

//        list.show();
    }

    @Test
    public void test(){
        try (ObjectOutputStream os = new ObjectOutputStream(
                new FileOutputStream("src/data_Structures/SkipListTest/a")
            );
            ObjectInputStream is = new ObjectInputStream(
                    new FileInputStream("src/data_Structures/SkipListTest/a")
            )){
            for (int i = 0; i < 10000; i++) {
                os.writeObject(i);
            }
            for (int i = 0; i < 10000; i++) {
                Integer a = (Integer) is.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
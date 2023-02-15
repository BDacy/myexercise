package data_Structures.SkipListTest;

import data_Structures.SkipListImpl.SkipList;
import data_Structures.SkipListImpl.SkipListArray;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

/**
 * @BelongsPackage: data_Structures.SkipListTest
 * @Author: yca
 * @CreateTime: 2023-02-15  10:04
 * @Description:
 */
public class SkipListArrayTest {
    @Test
    public void insertTest(){
        SkipList<Integer, String> skipList = new SkipListArray<>(3);
//        skipList.insert(10, "10");
//        skipList.insert(20, "20");
//        skipList.insert(30, "30");
//        skipList.insert(40, "40");
//        skipList.insert(50, "50");
//        skipList.insert(60, "60");
        int[] num = new int[10];
        for (int i = 0; i < 10; i++) {
            int n = new Random().nextInt(100);
            num[i] = n;
            skipList.insert(n, "" + n);
        }
        skipList.show();
        System.out.println(Arrays.toString(num));
    }

    @Test
    public void deleteTest(){
        SkipList<Integer, String> skipList = new SkipListArray<>(3);
        skipList.insert(10, "10");
        skipList.insert(20, "20");
        skipList.insert(30, "30");
        skipList.insert(40, "40");
        skipList.insert(50, "50");
        skipList.insert(60, "60");
        skipList.show();
        skipList.delete(20);
        skipList.delete(40);
        skipList.show();
    }

    @Test
    public void updateTest(){
        SkipList<Integer, String> skipList = new SkipListArray<>();
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
        skipList.show();
    }

    @Test
    public void searchTest(){
        SkipList<Integer, String> skipList = new SkipListArray<>(8);
        for (int i = 0; i < 1000; i++) {
            skipList.insert(i, "" + i);
        }
        for (int i = 0; i < 1000; i++) {
            assertEquals(skipList.search(i), "" + i);
        }
        skipList.show();
    }

    @Test
    public void existTest(){
        SkipList<Integer, String> skipList = new SkipListArray<>(6);
        for (int i = 1000; i < 2000; i++) {
            skipList.insert(i, "" + i);
        }
        for (int i = 1000; i < 2000; i++) {
            assertTrue(skipList.exist(i));
        }
        skipList.show();
        assertEquals(skipList.size(0), 1000);
    }


}
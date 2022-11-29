package review;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsPackage: review
 * @Author: yca
 * @CreateTime: 2022-11-27  17:04
 * @Description:
 */
public class Foreach {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<Integer>();
        List<Integer> linkList = new LinkedList<Integer>();
        // 每个集合插入10万条数据
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
            linkList.add(i);
        }

        int arry = 0;

        System.out.println("============遍历arrayList============");

        // 用for循环arrayList
        long forStartTime = System.currentTimeMillis();
        for (int i = 0; i < arrayList.size(); i++) {
            arry = arrayList.get(i);
        }
        long forEndTime = System.currentTimeMillis();
        System.out.println("for遍历需要：" + (forEndTime - forStartTime) + "毫秒");


        // 用增强for循环arrayList
        long forUpStartTime = System.currentTimeMillis();
        for (Integer in : arrayList) {
            arry = in;
        }
        long forUpEndTime = System.currentTimeMillis();
        System.out.println("增强for遍历需要：" + (forUpEndTime - forUpStartTime) + "毫秒");


        System.out.println("============linkList============");

        // 用for循环linkList
        long linkForStartTime = System.currentTimeMillis();
        int link = 0;
        for (int i = 0; i < linkList.size(); i++) {
            link = linkList.get(i);
        }
        long linkForEndTime = System.currentTimeMillis();
        System.out.println("for遍历：" + (linkForEndTime - linkForStartTime) + "毫秒");

        // 用增强for循环linkList
        long linkForeachStartTime = System.currentTimeMillis();
        for (Integer in : linkList) {
            link = in;
        }
        long linkForeachEndTime = System.currentTimeMillis();
        System.out.println("用增强for遍历需要：" + (linkForeachEndTime - linkForeachStartTime) + "毫秒");

    }
}
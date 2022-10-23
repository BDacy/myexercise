package mytest;

import org.junit.Test;

import java.util.*;

//集合测试
public class CollectTest {
    @Test
    public void ArrDemo(){
        //底层实现为数组
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int[] nums={9,8,7};
        System.out.println(list);
        list.addAll(list);
        System.out.println(list);
        System.out.println(list.indexOf(1));
        System.out.println(list.lastIndexOf(2));
    }
    @Test
    public void LinkDemo(){
        //LinkedList可以用做栈，多列，和双向队列
        //底层实现为双链表
        LinkedList<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2,5);
        System.out.println(list);
        System.out.println(list.peek());
        System.out.println(list.poll());
        System.out.println(list.offerFirst(10));
        System.out.println(list);
    }
    @Test
    public void ArrDequeDemo(){
        //通常用这个来当作栈或是队列，首选，次选为LinkedList
        //底层通过数组实现,且是循环数组
        ArrayDeque<Integer> arrayDeque=new ArrayDeque<>();
        arrayDeque.add(1);
        arrayDeque.add(10);
        arrayDeque.add(11);
        arrayDeque.addFirst(2);
        arrayDeque.addLast(3);
        arrayDeque.add(20);
        System.out.println(arrayDeque);
        System.out.println(arrayDeque.peek());
        System.out.println(arrayDeque.poll());
        System.out.println(arrayDeque.pop());
        System.out.println(arrayDeque);
    }
    @Test
    public void PriQueDemo(){
        //优先队列，就是个小顶堆，顶层是数组
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        int[] nums={12,32,1,56,3,766,2,0,2,56};
        for (int num : nums) {
            priorityQueue.add(num);
        }
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.contains(43));
        System.out.println(priorityQueue.poll());
        priorityQueue.remove();
        priorityQueue.remove(2);
        System.out.println(priorityQueue.element());
        System.out.println(priorityQueue);
    }
    @Test
    public void HashMapDemo(){
        Map<String,Integer> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

    }
}

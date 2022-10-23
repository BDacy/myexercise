package A_daily_topic.week2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: yca
 * @Date: 2022/09/15/10:46
 * @Description:
 *          341. 扁平化嵌套列表迭代器
 *          https://leetcode.cn/problems/flatten-nested-list-iterator/
 */
public class day4 {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return empty list if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
    public interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();

    }
    public class NestedIterator implements Iterator<Integer> {
        private Stack<Iterator<NestedInteger>> stack;
        private Integer res;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<Iterator<NestedInteger>>();
            stack.push(nestedList.iterator());
        }

        @Override
        public Integer next() {
            return res;
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()){
                Iterator<NestedInteger> iterator = stack.peek();
                if (!iterator.hasNext()){
                    stack.pop();
                    continue;
                }
                NestedInteger nestedInteger = iterator.next();
                if (nestedInteger.isInteger()){
                    res=nestedInteger.getInteger();
                    return true;
                }else {
                    stack.push(nestedInteger.getList().iterator());
                }
            }
            return false;
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}

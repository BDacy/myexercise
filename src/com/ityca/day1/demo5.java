package com.ityca.day1;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//71. 简化路径
public class demo5 {
    public static void main(String[] args) {
        String path="/a/b/s//c/.//../";
        System.out.println(Solution.simplifyPath(path));
    }
    class Solution {
        public static String simplifyPath(String path) {
            String[] split=path.split("/");
            Stack<String> stack=new Stack<>();
            for (String s : split) {
                if (s.equals("..")){
                    if (!stack.isEmpty()){
                        stack.pop();
                    }
                    }else if (!s.equals("")&&!s.equals(".")){
                    stack.push(s);
                }
            }
            String res=new String();
            if (stack.isEmpty()){
                res="/";
            }else{
                for (String s : stack) {
                    res=res+"/"+s;
                }
            }
            return res;
        }
    }
//    class Solution {
//        public static String simplifyPath(String path) {
//            //"/a/./b/../../c/"
//            String[] split = path.split("/");
//            LinkedList<String> queue=new LinkedList<String>();
//            for (String s : split) {
//                if (s.equals("..")){
//                    if (!queue.isEmpty())
//                    queue.removeLast();
//                }else if (s.equals("")||s.equals(".")){
//                }else {
//                    queue.add(s);
//                }
//            }
//            String res=new String("");
//            for (String s : queue) {
//                res=res+"/"+s;
//            }
//            if (res.equals("")){
//                res=res+"/";
//            }
//            return res;
//        }
//    }
}

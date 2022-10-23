package DDL;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ddlDemo2 {
    public static void main(String[] args) throws IOException {
//        //创建一个初始的邻接矩阵
//        Graph<String> graph=new Graph<>(6);
//        //规定没有边的值取0
//        //后续会进行转值操作
//        int[][] matrix={
//                {0,6,3,0,0,0},
//                {6,0,2,5,0,0},
//                {3,2,0,3,4,0},
//                {0,5,3,0,2,3},
//                {0,0,4,2,0,5},
//                {0,0,0,3,5,0}
//        };
//
//        graph.setMatrix(matrix);
//        graph.setNames(new String[]{"A","B","C","D","E","F"});
//        graph.initMatrix();
//        //查找每一个节点到各个节点的最短路径
//        for (int i=0;i<6;i++){
//            graph.initStates();
//            System.out.println(Arrays.toString(graph.Dijkstra(i)));
//        }
//        graph.Store("D:\\Users\\大朋友五\\Desktop\\index");
//        List<Map<String, Integer>>lists =new ArrayList<>();
//        String[] names=new String[6];
//        Graph.load(lists,names,"D:\\Users\\大朋友五\\Desktop\\index", 6);
//        System.out.println();
//        for (Map<String, Integer> list : lists) {
//            System.out.println(list);
//        }
//        System.out.println();
//        String name="F";
//        String[] res=graph.findKName(lists,name,5);
//        Map<String,Integer> map=graph.findKMap(lists,name,5);
//
//        System.out.println(Arrays.toString(res));
//        System.out.println();
//        System.out.println(map);
//        System.out.println(map.get("E"));
        test();
    }

    /**
     * desc:提供一个测试函数，实现数据存储与使用
     * @throws IOException
     */
    public static void test() throws IOException {
        //定义矩阵大小，有多少个点
        //超过26个时，建议使用字符串命名
        int n=10;
        //随机初始化一个n*n的矩阵
        int[][] matrix = CreateData(n);
        //创建Graph对象，此对象进行最短路径的计算
        Graph graph=new Graph(n);
        //各个节点的名称
        String[] names=new String[n];
        //这里测试使用字母
        for (int i=0;i<n;i++){
            //字母命名
            names[i]=Character.toString('A'+i);
            //字符串命名
//            names[i]="A"+i;
        }
        graph.setNames(names);
        graph.setMatrix(matrix);
        //初始化矩阵
        graph.initMatrix();
        for (int i=0;i<n;i++){
            graph.initStates();
            //对每个节点进行一次Dijkstra算法，获得
            System.out.println(Arrays.toString(graph.Dijkstra(i)));
        }
        System.out.println();
        //将计算的最短路径结果进行存储到文件中去
        graph.Store("D:\\Users\\大朋友五\\Desktop\\index1.txt");
        //KCL对象负责读取事先存储好的最短路径文件,进行k近邻查询
        KCL kcl=new KCL("D:\\Users\\大朋友五\\Desktop\\index1.txt",n);
        System.out.println(Arrays.toString(kcl.getNames()));
        System.out.println();
        System.out.println(kcl.getMapList());
        System.out.println();
        System.out.println(Arrays.toString(kcl.findKName("E",5)));
        System.out.println();
        System.out.println(kcl.findKMap("A", 4));
        System.out.println(kcl.findKMap("B", 4));
    }
    //数据自生成
    public static int[][] CreateData(int n){
        int [][] data=new int[n][n];
        Random random=new Random();
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (i==j) data[i][j]=0;
                else{
                    if (random.nextInt(10)>4){
                        data[i][j]=random.nextInt(10,100);
                    }else
                        data[i][j]=0;
                }
            }
        }
        return data;
    }
}

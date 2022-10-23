package DDL;

import java.util.Arrays;
import java.util.Random;

//此程序用于调试测试Floyd算法
public class AlTest {
    public static void main(String[] args) {
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
//            names[i]=Character.toString('A'+i);
            //字符串命名
            names[i]="A"+i;
        }
        graph.setNames(names);
        graph.setMatrix(matrix);
        //初始化矩阵
        graph.initMatrix();
        //测试结果是否相同
        //调用Floyd算法
        int[][] a1=new int[n][n];
        int[][] floyd = graph.Floyd();
        a1=floyd;
        for (int[] ints : floyd) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
        //使用Dijkstra算法
        int[][] a2=new int[n][n];
        for (int i=0;i<n;i++){
            graph.initStates();
            //对每个节点进行一次Dijkstra算法，获得
            a2[i]=graph.Dijkstra(i);
            System.out.println(Arrays.toString(a2[i]));
        }
        System.out.println();
        //使用Bellman_Ford算法
        int[][] a3=new int[n][n];
        for (int i=0;i<n;i++){
            //对每个节点进行一次Bellman_Ford算法，获得
            a3[i]=graph.Bellman_Ford(i);
            System.out.println(Arrays.toString(a3[i]));
        }
        System.out.println();
        //使用SPFA算法
        int[][] a4=new int[n][n];
        for (int i=0;i<n;i++){
            graph.initStates();
            //对每个节点进行一次SPFA算法，获得
            a4[i]=graph.SPFA(i);
            System.out.println(Arrays.toString(a4[i]));
        }
        System.out.println();
        //使用SPFA算法
        int[][] a5=new int[n][n];
        for (int i=0;i<n;i++){
            graph.initStates();
            //对每个节点进行一次SPFA算法，获得
            a5[i]=graph.DFS(i);
            System.out.println(Arrays.toString(a5[i]));
        }
        check(a1,a2);
        check(a2,a3);
        check(a3,a4);
        check(a2,a5);
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
    //检测两个二维矩阵是否相同
    public static void check(int[][] a,int[][] b){
        if (a.length!= b.length||a[0].length!=b[0].length){
            System.out.println("不同");
            return;
        }
        int n=a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j]!=b[i][j]){
                    System.out.println("两矩阵不同");
                    return;
                }
            }
        }
        System.out.println("两矩阵相同");

    }
}

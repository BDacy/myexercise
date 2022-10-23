package DDL;

import java.io.*;
import java.util.*;

//对图的表示
public class Graph <T>{
    private int N;//N个节点
    private int[][] matrix;//邻接矩阵，用来存放节点之间边的距离
    private State[] states;//保存每个节点的状态，是否访问过
    private String[] names;//节点的别名
    private T[] datas;//保存每个节点存放的数据,泛型自定义数据类型
    private int min=Integer.MAX_VALUE;//给DFS使用
    //初始化
    public Graph(int N){
        this.N=N;
        this.matrix=new int[N][N];
        this.states=new State[N];
        this.names=new String[N];
        this.datas= (T[]) new Object[N];
        //对每个节点访问状态的初始化
        initStates();
    }

    /**
     * 获取节点名称
     * @param mapList 缓存的最短路径矩阵
     * @return 节点名称数组
     */
    public static String[] GetNodeNames(List<Map<String, Integer>> mapList) {
        String[] NodeNames=new String[mapList.size()];
        Map<String, Integer> map = mapList.get(0);
        int i=0;
        for (String s : map.keySet()) {
            NodeNames[i++]=s;
        }
        return NodeNames;
    }

    /**
     *
     * @param index 从该节点出发的索引号
     * @return 返回一个该点到各点的数组,记录最短路径
     */
    public int[] Dijkstra(int index){
        if (index<0||index>this.N){
            System.out.println("输入索引不正确");
        }
        int[] dist=new int[N];//到各个节点的最短距离值
        //将其设置为最大值
        for(int i=0;i<N;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[index]=0;//到自己的距离为0
        //临时指针
        int p=index;
        //dist中当前最小值索引
        int minIndex=index;
        //上一轮的最小值
        int preMin=0;
        //直到所有节点都被访问
        while (!isAllVisit()){
            if(preMin == Integer.MAX_VALUE) break;
            //设置当前最小值
            int nowMin=Integer.MAX_VALUE;
            //更新dist的值
            states[p]=State.Visit;//设置为已经访问
            for (int i=0;i<N;i++){
                //访问过，当前节点已经是最小值，就跳过
                if (states[i]==State.Visit)continue;
                //更新dist[i]的值
                //如果计算的值比存放值要小，则更新,加个判断避免运算溢出
                if (matrix[p][i]!=Integer.MAX_VALUE&&(preMin+matrix[p][i]<dist[i])){
                    dist[i]=preMin+matrix[p][i];
                }
                //当前最小值的筛选
                if (dist[i]<nowMin){
                    nowMin=dist[i];
                    minIndex=i;//更新这一轮最小值的下标
                }
            }
            preMin=nowMin;//交接更替
            p=minIndex;//下一轮从这一轮的最小值出发
        }
        return dist;
    }

    /**
     * desc: 采用Floyd算法实现最短距离的计算
     * @return 返回一个n*n的最短距离二维数组
     */
    public int[][] Floyd(){
        int[][] res = new int[N][N];
        //path 的初始化,复制matrix的值
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res[i][j]=matrix[i][j];
            }
        }
        //保存距离
        int len;
        //对中间顶点遍历
        for (int k = 0; k < N; k++) {
            //从i顶点开始出发
            for (int i = 0; i < N; i++) {
                //到达j顶点
                for (int j = 0; j < N; j++) {
                    //求出从i顶点出发经过k到达j的距离
                    if (res[i][k]==Integer.MAX_VALUE||res[k][j]==Integer.MAX_VALUE)
                        continue;
                    len = res[i][k] + res[k][j];
                    //若len小于dis[i][j],则进行更新
                    if (len < res[i][j]) {
                        //更新距离
                        res[i][j] = len;
//                        //更新前驱顶点
//                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }
        return res;
    }

    /**
     * desc : 采用Bellman_Ford算法计算单点到其他点走k条边的最短距离
     *         可以用在边的权重为负的情况下
     * @return 返回一个该点到各点的数组,记录最短路径
     */
    public int[] Bellman_Ford(int index){
        if (index<0||index>this.N){
            System.out.println("输入索引不正确");
        }
        int[] dist=new int[N];//到各个节点的最短距离值
        int[] preNode = new int[N];//记录前置节点
        //将其设置为最大值
        for(int i=0;i<N;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[index]=0;//到自己的距离为0
        boolean flag;
        //n-1次的松弛必然得到最短路径.
        for (int i = 0; i < N - 1; i++) {
            flag=true;
            //遍历所有边
            for (int j = 0; j < N; j++) {//j是中转站
                for (int k = 0; k < N; k++) {
                    if (matrix[j][k]==Integer.MAX_VALUE||dist[j]==Integer.MAX_VALUE)continue;
                    if (dist[j]+matrix[j][k]<dist[k]){
                        dist[k]=dist[j]+matrix[j][k];
                        flag=false;//更新有效
                        preNode[k]=j;//后续可通过栈的方式取出路径
                    }
                }
            }
            if (flag==true){
                return dist;//如果没有更新，则提前结束
            }
        }
        //负权环的检查
        //遍历所有边，和上面一样，如果n-1次松弛后还有更新，则说明有负权环
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j]==Integer.MAX_VALUE||dist[i]==Integer.MAX_VALUE)continue;
                if (dist[i]+matrix[i][j]<dist[j]){
                    System.out.println("存在负权环");
                    return dist;
                }
            }
        }
        return dist;
    }


    /**
     * desc 使用优先队列优化的Bellman_Ford算法
     * @param index 查找索引
     * @return 返回一个该点到各点的数组,记录最短路径
     */
    public int[] SPFA(int index){
        if (index<0||index>this.N){
            System.out.println("输入索引不正确");
        }
        int[] dist=new int[N];//到各个节点的最短距离值
        int[] preNode = new int[N];//记录前置节点
        //将其设置为最大值
        for(int i=0;i<N;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[index]=0;//到自己的距离为0
        //创建优先队列存放节点
        Queue<Integer> queue=new LinkedList<>();
        //开始队列存入源节点
        queue.add(index);
        //为了避免因为负权值的存在导致陷入死循环,利用states访问来限制次数
        states[index]=State.Visit;
        //进行循环更新，直到队列为空
        while (!queue.isEmpty()){
            int v=queue.poll();
            states[v]=State.unVisit;
            //遍历v所连接的所有边
            for (int i = 0; i < N; i++) {
                if (matrix[v][i]==Integer.MAX_VALUE)continue;
                if ((dist[v]+matrix[v][i])<dist[i]){
                    //更新
                    dist[i]=dist[v]+matrix[v][i];
                    if (states[i]==State.Visit)//如果更新过了
                        continue;
                    //没有更新则添入队列
                    //把得到更新的节点放入队列
                    queue.add(i);
                    states[i]=State.Visit;
                }

            }
        }
        return dist;
    }

    /**
     * desc 深度优先算法
     * @param index 查找索引
     * @return 返回一个该点到各点的数组,记录最短路径
     */
    public int[] DFS(int index){
        if (index<0||index>this.N){
            System.out.println("输入索引不正确");
        }
        int[] dist=new int[N];//到各个节点的最短距离值
        //将其设置为最大值
        for(int i=0;i<N;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[index]=0;//到自己的距离为0
        for (int i = 0; i < N; i++) {
            if (i==index)continue;
            dfs(index,i,0);
            dist[i]=min;
            min=Integer.MAX_VALUE;//恢复初始值
        }
        return dist;
    }
    private void dfs(int from, int to,int dist) {
        if (min<dist){
            return;
        }
        if (from==to){
            if (dist<min){
                min=dist;
                dist=0;
                return;
            }
        }
        for (int i = 0; i < N; i++) {
            if (i==from)continue;
            if (matrix[from][i]!=Integer.MAX_VALUE&&states[i]==State.unVisit){
                states[i]=State.Visit;
                dfs(i,to,dist+matrix[from][i]);
                states[i]=State.unVisit;
            }
        }
        return;
    }

//    private int[] BFS(int index){
//        if (index<0||index>this.N){
//            System.out.println("输入索引不正确");
//        }
//        int[] dist=new int[N];//到各个节点的最短距离值
//        //将其设置为最大值
//        for(int i=0;i<N;i++){
//            dist[i]=Integer.MAX_VALUE;
//        }
//        dist[index]=0;//到自己的距离为0
//
//        return dist;
//    }
    /**
     * desc:初始化矩阵,把矩阵
     * 除了自身节点到自身节点的为0的路径换成最大值
     */
    public void initMatrix(){
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if (i!=j&&matrix[i][j]==0){
                    matrix[i][j]=Integer.MAX_VALUE;
                }
            }
        }
    }

    /**
     * desc: 把每个节点的状态变成未访问
     */
    public void initStates(){
        //把每个节点的状态变成未访问
        for (int i=0;i<N;i++){
            this.states[i]=State.unVisit;
        }
    }

    /**
     * desc:是否节点都被访问过
     * @return: 都访问过 return Ture,有未访问的 return False
     */
    public boolean isAllVisit(){
        for (State state : this.states) {
            if (state!=State.Visit)
                return false;
        }
        return true;
    }

    /**
     * desc: 存入KV矩阵，第一行文本为节点名称
     * @param filename 要存储的文件路径
     */
    public void Store(String filename) throws IOException {
        PrintWriter printWriter=new PrintWriter(filename);
        //第一行文本内容为节点名称
        for (String name : names) {
            printWriter.print(name+"\t");
        }
        printWriter.println();
        for (int i=0;i<N;i++){
            initStates();
            //获取最短路径
            int[] dists=Dijkstra(i);
            //存放每一行的最短路径表，每一个节点的为结构<"A":10>
            Map<String,Integer> map=new HashMap<>();
            for (int j=0;j<N;j++){
                map.put(names[j],dists[j]);
            }
            List<Map.Entry<String,Integer>> entryList=new ArrayList<>(map.entrySet());
            //根据value进行升序排序
            Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });
            System.out.println(entryList);;
//            //直接打印
//            printWriter.println(entryList);
            //逐个打印，输出到文件中
            for (Map.Entry<String, Integer> entry : entryList) {
                printWriter.print(entry+"\t");
            }
            printWriter.println();
        }
        printWriter.close();
    }

    /**
     * 读取文件加载到内存中
     * @param mapList 最短距离矩阵
     * @param names 节点名称
     * @param filename 文件名
     * @param n 矩阵大小
     * @throws IOException
     */
    public static void load(List<Map<String, Integer>> mapList,String[] names,String filename, int n) throws IOException {
        Reader reader=new FileReader(filename);
        BufferedReader bufferedReader=new BufferedReader(reader);
        String line;
        int i=0;
        while ((line= bufferedReader.readLine())!=null){
            //第一行文本内容送给节点名称数组
            if (i==0){
                int j=0;
                for (String s : line.split("\t")) {
                    names[j++]=s;
                }
                i++;
                continue;
            }
            mapList.add(new LinkedHashMap<>());
            String[] split = line.split("\t");
            Map<String, Integer> map = mapList.get(i-1);
            for (String s : split) {
                String[] split1 = s.split("=");
                map.put(split1[0],Integer.parseInt(split1[1]));
            }
            i++;
        }
        bufferedReader.close();
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public T[] getDatas() {
        return datas;
    }

    public void setDatas(T[] datas) {
        this.datas = datas;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    /**
     *
     * @param indexes 缓存好的最短路径矩阵
     * @param name 查询点的名字
     * @param k 寻找近邻点的个数
     * @return k个近邻点的名字
     */
    public String[] findKName(List<Map<String, Integer>> indexes, String name, int k) {
        if (k<0||k>=N){
            System.out.println("k值不合法");
            return null;
        }
       String[] res=new String[k];
        //寻找name的下标
        int index=-1;
        for (int i=0;i<N;i++){
            if (names[i].equals(name)){
                index=i;
                break;
            }
        }
        if (index==-1){
            System.out.println("节点名称不存在");
            return null;
        }
        //获取查询点的index后,确定了indexes要取的行
        Map<String, Integer> map = indexes.get(index);
        //排除第一个，取前k个
        int i=1;
        for (String s : map.keySet()) {
            if (i==1) {
                i++;
                continue;
            }
            if (i==k+2)break;
            if (map.get(s)==Integer.MAX_VALUE){
                System.out.println("对不起,该节点的连通节点只有"+(i-2)+"个(不包括自身节点)\n"
                        +"只返回"+(i-2)+"个节点名称");
                String [] tmp = new String[i-2];
                for (int j = 0; j < i - 2; j++) {
                    tmp[j]=res[j];
                }
                return tmp;
            }
            res[i-2]=s;
            i++;
        }
        return res;
    }

    /**
     * desc: 查找离查询点为name最短距离的前k个
     * @param indexes 缓存索引，最短距离矩阵
     * @param name 查询点名字
     * @param k 寻找近邻点数目
     * @return 前k个近邻点集合Map
     */
    public Map<String, Integer> findKMap(List<Map<String, Integer>> indexes, String name, int k) {
        Map<String,Integer> res=new LinkedHashMap<>();
        //检查参数有效性
        if (k<0||k>=N){
            System.out.println("k值不合法");
            return null;
        }
        //寻找name的下标
        int index=-1;
        for (int i=0;i<N;i++){
            if (names[i]==name){
                index=i;
                break;
            }
        }
        if (index==-1){
            System.out.println("节点名称不存在");
            return null;
        }
        //获取查询点的index后,确定了indexes要取的行
        Map<String, Integer> map = indexes.get(index);
        //排除第一个，取前k个
        int i=1;
        for (String s : map.keySet()) {
            if (i==1) {
                i++;
                continue;
            }
            if (i==k+2)break;
            res.put(s,map.get(s));
            i++;
        }
        return res;
    }
}

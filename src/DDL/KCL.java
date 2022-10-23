package DDL;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class KCL {
    private int N;
    private String[] names;
    private List<Map<String, Integer>> mapList;

    public KCL(){}
    public KCL(int n, String[] names, List<Map<String, Integer>> mapList) {
        N = n;
        this.names = names;
        this.mapList = mapList;
    }

    public KCL(String filename,int n) throws IOException {
        this.N=n;
        names=new String[N];
        mapList=new ArrayList<>();
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

    /**
     *
     * @param name 查询点的名字
     * @param k 寻找近邻点的个数
     * @return k个近邻点的名字
     */
    public String[] findKName(String name, int k) {
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
        Map<String, Integer> map = mapList.get(index);
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
     * @param name 查询点名字
     * @param k 寻找近邻点数目
     * @return 前k个近邻点集合Map
     */
    public Map<String, Integer> findKMap(String name, int k) {
        Map<String,Integer> res=new LinkedHashMap<>();
        //检查参数有效性
        if (k<0||k>=N){
            System.out.println("k值不合法");
            return null;
        }
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
        Map<String, Integer> map = mapList.get(index);
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
                        +"只返回"+(i-2)+"个节点");
                break;
            }
            res.put(s,map.get(s));
            i++;
        }
        return res;
    }
    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public List<Map<String, Integer>> getMapList() {
        return mapList;
    }

    public void setMapList(List<Map<String, Integer>> mapList) {
        this.mapList = mapList;
    }
}

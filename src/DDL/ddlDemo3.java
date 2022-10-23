package DDL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ddlDemo3 {
    public static void main(String[] args) throws IOException {
        //每次查询节点时，要先读取缓存，然后获取节点名称，根据节点名称来进行查询
        List<Map<String, Integer>> mapList =new ArrayList<>();
        String[] nodeNames=new String[6];
//        Graph.load(mapList,nodeNames,"D:\\Users\\大朋友五\\Desktop\\index", 6);
        System.out.println(Arrays.toString(nodeNames));
        //封装好一个KCL类，new一个这个类进去K查询
        KCL kcl=new KCL("D:\\Users\\大朋友五\\Desktop\\index",6);
        System.out.println(Arrays.toString(kcl.getNames()));
        System.out.println(kcl.getMapList());
        System.out.println(Arrays.toString(kcl.findKName("E",5)));
        System.out.println(kcl.findKMap("A", 4));
        System.out.println(kcl.findKMap("B", 4));
    }
}

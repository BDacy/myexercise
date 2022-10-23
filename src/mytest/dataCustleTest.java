package mytest;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class dataCustleTest {
    @Test
    public void etl() throws IOException {
        Reader reader =new FileReader("E:\\dataCustle\\customer_churn_judgment\\train.csv");
        BufferedReader br= new BufferedReader(reader);
        String line;
        // 读取第一行
        line= br.readLine();
        String[] features = line.split(",");
        System.out.println(Arrays.toString(features));
        int n=features.length;
        LinkedHashMap<String, ArrayList<String>> map=new LinkedHashMap<>();
        ArrayList<String>[] lists=new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i]=new ArrayList<>();
            map.put(features[i],lists[i]);
        }
        while ((line= br.readLine())!=null){
            String[] splits = line.split(",");
            for (int i = 0; i < n; i++) {
                if (!lists[i].contains(splits[i])) {
                    lists[i].add(splits[i]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ArrayList<String> list = map.get(features[i]);
            System.out.println(features[i]+":"+list.toString());
        }
    }
}

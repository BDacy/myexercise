package mytest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class test02 {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream is=new FileInputStream("D:\\code\\Java\\Javasepro\\myexercise\\src\\mytest\\data.txt");
        InputStream isa=new FileInputStream("myexercise/src/mytest/data.txt");
    }
}

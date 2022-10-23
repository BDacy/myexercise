package DesignPattern.Builder;

public class Consumer {
    public static void main(String[] args) {
        Builder worker=new Worker();
        Product product = worker
                .builderA("yca")
                .builderB("xzz")
                .builderC("lzh")
                .builderD("zjy")
                .getProduct();
        System.out.println(product);
    }
}

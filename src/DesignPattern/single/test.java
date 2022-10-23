package DesignPattern.single;

public class test {
    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
                Lazy instance = Lazy.getInstance();
            }).start();
        }
    }
}

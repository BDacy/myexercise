package DesignPattern.single;
//单例模式
public class Lazy {
    private volatile static Lazy uniqueInstance;

    private Lazy(){
        System.out.println(Thread.currentThread().getName()+" ok");
    }
    public static Lazy getInstance(){
        if (uniqueInstance==null){
            synchronized (Lazy.class){
                if (uniqueInstance==null)
                uniqueInstance = new Lazy();
            }
        }
        return uniqueInstance;
    }
}

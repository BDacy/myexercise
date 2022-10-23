package MultiThread.ThreadBase;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个继承Thread对象的MyThread类，调用start()方法执行线程
        MyThread thread1=new MyThread();
        //创建一个继承Runnable接口的对象的MyRunnable类
        MyRunnable myRunnable=new MyRunnable();
        //创建Thread类包装MYRunnable,调用start()方法执行
        Thread thread2=new Thread(myRunnable,"thread2");
//        创建 Callable 接口的实现类，并实现 call 方法。该 call 方法将作为线程执行体，并且有返回值。
        Callable<Long> callable=new MyCallable();
//        创建 Callable 实现类的实例，使用 FutureTask 类来包装 Callable 对象，该 FutureTask 对象封装了该 Callable 对象的 call 方法的返回值。
        FutureTask<Long> futureTask =new FutureTask<>(callable);
//        使用 FutureTask 对象作为 Thread 对象的 target 创建并启动新线程。
        new Thread(futureTask,"Callable 线程").start();
//        调用 FutureTask 对象的 get 方法来获得线程执行结束后的返回值。
        System.out.println("任务耗时：" + (futureTask.get() / 1000000) + "毫秒");
        thread2.start();
        thread1.start();
        System.out.println(thread2.getName());
        System.out.println("运行结束");

    }
}

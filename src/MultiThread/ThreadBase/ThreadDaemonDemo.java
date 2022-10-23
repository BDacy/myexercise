package MultiThread.ThreadBase;

public class ThreadDaemonDemo {
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        Thread thread=new Thread(myThread,"MyThread");
        thread.setDaemon(true);
        System.out.println("该线程是否为守护线程:"+thread.isDaemon());
        thread.start();
    }
    static class MyThread implements Runnable{
        @Override
        public void run() {
            while (true)
            System.out.println(Thread.currentThread().getName()+"线程启动");
        }
    }
}

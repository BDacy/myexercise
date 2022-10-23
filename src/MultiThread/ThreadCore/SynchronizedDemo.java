package MultiThread.ThreadCore;

public class SynchronizedDemo implements Runnable{
    public static final int MAX = 100000;

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo instance = new SynchronizedDemo();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
    @Override
    public void run() {
        for (int i = 0; i < MAX; i++) {
            increase();
        }
    }

    public synchronized void increase() {
        count++;
    }
}

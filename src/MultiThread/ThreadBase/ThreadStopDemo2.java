package MultiThread.ThreadBase;

import java.util.concurrent.TimeUnit;

public class ThreadStopDemo2 {
    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "MyTask");
        thread.start();
        TimeUnit.MILLISECONDS.sleep(5);
        task.cancel();
    }
    private static class MyTask implements Runnable {

        private volatile boolean flag = true;
        private volatile long count = 0L;
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 线程启动");
            while (flag) {
                System.out.println(count++);
            }
            System.out.println(Thread.currentThread().getName() + " 线程终止");
        }

        /**
         * 通过 volatile 标志位来控制线程终止
         */
        public void cancel() {
            flag = false;
        }

    }
}

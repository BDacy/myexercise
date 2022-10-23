package MultiThread.ThreadBase;
//线程休眠
public class ThreadSleepDemo {
    public static void main(String[] args) {
        new Thread(new MyThread("thread1",500)).start();
        new Thread(new MyThread("thread2",1000)).start();
        new Thread(new MyThread("thread3",1500)).start();

    }
    static class MyThread implements Runnable{
        /** 线程名称 */
        private String name;
        /** 休眠时间 */
        private int time;
        public MyThread(String name, int time) {
            this.name = name;
            this.time = time;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(this.time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.name + "休眠" + this.time + "毫秒。");
        }
    }
}

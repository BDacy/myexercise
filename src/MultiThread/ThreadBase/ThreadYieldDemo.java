package MultiThread.ThreadBase;

public class ThreadYieldDemo {
    public static void main(String[] args) {
        MyThread thread=new MyThread();
        new Thread(thread,"线程A").start();
        new Thread(thread,"线程B").start();
    }
    static class MyThread implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"运行,i="+i);
                if (i==2){
                    System.out.println("线程礼让");
                    Thread.yield();
                }
            }
        }
    }
}

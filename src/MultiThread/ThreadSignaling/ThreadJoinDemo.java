package MultiThread.ThreadSignaling;

public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread=new MyThread();
        Thread thread1=new Thread(myThread,"线程A");
        Thread thread2=new Thread(myThread,"线程B");
        Thread thread3=new Thread(myThread,"线程C");
        thread1.start();
        thread2.start();
        thread3.start();

    }
    static class MyThread implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

package MultiThread.ThreadBase;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Long> {
    private long ticket=1000;
    @Override
    public Long call() throws Exception {
        long begin=System.nanoTime();
        while (ticket>0){
            System.out.println(Thread.currentThread().getName()+"卖出了第"+ticket+"张票");
            ticket--;
        }
        long end=System.nanoTime();
        return end-begin;
    }
}

package MultiThread.ThreadMyTest;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockTest {
    public static void main(String[] args) {
        LockExample lockExample = new LockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->lockExample.func());
        executorService.execute(()->lockExample.func());
        executorService.shutdown();
    }
}

package synchronisation;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    private static final int THREAD_COUNT = 10;

    private static ExecutorService threadPool = Executors
            .newFixedThreadPool(THREAD_COUNT);

    private static Semaphore s = new Semaphore(3);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int num = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Waiting... "+Thread.currentThread().getName()+"--data--"+num);
                        s.acquire();
                        System.out.println(Thread.currentThread().getName()+"--save data--"+num);//"One more is in use "+s.drainPermits()+"   "+
                        s.release();
                        System.out.println("One is released ");
                    } catch (InterruptedException e) {
                    }
                }
            });
        }

        threadPool.shutdown();
    }
}
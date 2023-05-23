package semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(9);
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            executors.execute(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " working w file system");
                try {
                    Thread.sleep(300);
                    semaphore.acquire();
                    workWithFileSystem();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }
                System.out.println(threadName + " is done");
            });
        }
        executors.shutdown();
    }

    private static void workWithFileSystem() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started working w file system");
        Thread.sleep(1000);
        System.out.println(threadName + " finished working w file system");
    }
}

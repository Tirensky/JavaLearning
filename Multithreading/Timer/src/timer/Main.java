package timer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executors = Executors.newSingleThreadExecutor(r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });

        executors.execute(() -> {
            int seconds = 0;
            try {
                while (true) {
                    System.out.println(seconds++);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        for (int i = 0; i < 10; i++) {
            System.out.println("...");
            Thread.sleep(1000);
        }
        System.out.println("Finish!");
    }
}

package countdown;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(7);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executors.execute(() -> {
                System.out.println("Start - " + index);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Finish - " + index);
            });
        }
        executors.shutdown();

        System.out.println("All threads are terminated!");
    }
}

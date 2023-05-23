package cyclic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                long millis = (long) (Math.random() * 4000 + 1001);
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + ": data is being prepared.");
                try {
                    Thread.sleep(millis);
                    System.out.println(threadName + ": data is ready!");
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(threadName + ": continue work.");
            }).start();
        }
    }
}

package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        // by static method of Collections class. Slow.
        List<Integer> numbers1 = Collections.synchronizedList(new ArrayList<>());
        // by ready-to-use sync collections. Fast. Optimized.
        List<Integer> numbers2 = new CopyOnWriteArrayList<>();

        addTo(numbers1, latch).start();
        addTo(numbers1, latch).start();

        addTo(numbers2, latch).start();
        addTo(numbers2, latch).start();

        latch.await();
        System.out.println("Size 1: " + numbers1.size());
        System.out.println("Size 2: " + numbers2.size());
    }

    private static Thread addTo(List<Integer> list, CountDownLatch latch) {
        return new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(100);
                    list.add(i);
                }
                latch.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

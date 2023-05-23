package exeservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Solution {
    private static final int BARRIER = 1_000_000;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executors = Executors.newSingleThreadExecutor();
        CountDownLatch latch = new CountDownLatch(3);

        long before = System.currentTimeMillis();

        executors.execute(() -> {
            sumOfNumbersDividedBy(2);
            latch.countDown();
        });
        executors.execute(() -> {
            sumOfNumbersDividedBy(7);
            latch.countDown();
        });
        executors.execute(() -> {
            List<Integer> randoms = new ArrayList<>();
            Random rnd = new Random();

            int count = 0;
            for (int i = 0; i < 1000; i++) {
                randoms.add(rnd.nextInt(1000));
                if (randoms.get(i) % 2 == 0) count++;
            }

            System.out.println("Count of even random nums: " + count);
            latch.countDown();
        });
        executors.shutdown();
        latch.await();

        long after = System.currentTimeMillis();
        System.out.println("Time: " + (after - before) + "ms");
    }

    private static void sumOfNumbersDividedBy(int n) {
        long result = 0;
        for (int i = 0; i < BARRIER; i++) {
            if (i % n == 0) result += i;
        }
        System.out.println("Sum of nums divided by " + n + ": " + result);
    }
}

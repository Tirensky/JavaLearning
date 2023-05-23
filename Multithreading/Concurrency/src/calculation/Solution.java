package calculation;

import java.util.Arrays;

public class Solution {
    private static final int SIZE = 55_000_000;
    private static final int FIRST_HALF = SIZE / 2;
    private static final int SECOND_HALF = SIZE - FIRST_HALF;

    private static float[] array = new float[SIZE];

    public static void main(String[] args) {
        Arrays.fill(array, 1);

        startTimer();
        new Thread(() -> {
            withoutConcurrency(array);
        }).start();
        new Thread(() -> {
            try {
                withConcurrency(array);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private static void withoutConcurrency(float[] array) {
        long before = System.currentTimeMillis();

        fillArrayByDifficultValues(array, 0);

        long after = System.currentTimeMillis();
        System.out.println("Time w/o concurrency: " + (after - before));
    }

    private static void withConcurrency(float[] array) throws InterruptedException {
        long before = System.currentTimeMillis();

        float[] first = new float[FIRST_HALF];
        float[] second = new float[SECOND_HALF];

        System.arraycopy(array, 0, first, 0, FIRST_HALF);
        System.arraycopy(array, SECOND_HALF, second, 0, SECOND_HALF);

        Thread thread1 = new Thread(() -> fillArrayByDifficultValues(first, 0));
        Thread thread2 = new Thread(() -> fillArrayByDifficultValues(second, FIRST_HALF));

        thread1.start();
        thread2.start();

        thread1.join();
        thread1.join();

        System.arraycopy(first, 0, array, 0, FIRST_HALF);
        System.arraycopy(second, 0, array, FIRST_HALF, SECOND_HALF);

        long after = System.currentTimeMillis();
        System.out.println("Time w/ concurrency: " + (after - before));
    }

    private static void fillArrayByDifficultValues(float[] array, int srcPos) {
        for (int i = 0; i < array.length; i++) {
            float f = i + srcPos;
            array[i] = (float) (array[i] * Math.sin(0.2f + f / 5)
                    * Math.cos(0.2f + f / 5)
                    * Math.cos(0.4f + f / 2));
        }
    }

    private static void startTimer() {
        Thread timer = new Thread(() -> {
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
        timer.setDaemon(true);
        timer.start();
    }
}

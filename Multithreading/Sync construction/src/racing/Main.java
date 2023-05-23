package racing;

import java.util.Map;
import java.util.concurrent.*;

public class Main {
    private static final int TUNNEL_CARS_COUNT = 3;
    private static final int CARS_COUNT = 10;

    private static final Semaphore tunnelSemaphore = new Semaphore(TUNNEL_CARS_COUNT);
    private static final ExecutorService executor = Executors.newCachedThreadPool();
    private static final CyclicBarrier barrier = new CyclicBarrier(CARS_COUNT);
    private static final CountDownLatch latch = new CountDownLatch(CARS_COUNT);
    private static final Object monitor = new Object();

    private static final Map<Integer, Long> scoreboard = new ConcurrentHashMap<>();

    private static volatile int winnerIndex = -1;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < CARS_COUNT; i++) {
            final int index = i;
            executor.execute(() -> {
                // first need to prepare
                prepare(index);
                // wait until all cars are ready to start
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                long before = System.currentTimeMillis();

                startRoad(index);
                tunnel(index);
                finishRoad(index);

                synchronized (monitor) {
                    if (winnerIndex == -1) winnerIndex = index;
                }

                long after = System.currentTimeMillis();
                scoreboard.put(index, after - before);
                latch.countDown();
            });
        }
        latch.await();
        executor.shutdown();

        System.out.println("--------------------------");
        System.out.println("|       Scoreboard       |");
        System.out.println("--------------------------");
        for (int score : scoreboard.keySet()) {
            System.out.println("Car " + score + ": " + scoreboard.get(score) + " ms");
        }
        System.out.println("--------------------------");

        System.out.println("Winner: Car " + winnerIndex + " (Best time: " + scoreboard.get(winnerIndex) + " ms)");
    }

    private static void randomSleepTime() {
        long millis = (long) (Math.random() * 4000 + 1001);
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void prepare(int index) {
        System.out.println("Car " + index + " started preparing");
        randomSleepTime();
        System.out.println("Car " + index + " finished preparing");
    }

    private static void startRoad(int index) {
        System.out.println("Car " + index + " started the race");
        randomSleepTime();
        System.out.println("Car " + index + " before the tunnel");
    }

    private static void tunnel(int index) {
        try {
            tunnelSemaphore.acquire();
            System.out.println("Car " + index + " entered the tunnel");
            randomSleepTime();
            System.out.println("Car " + index + " left the tunnel");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            tunnelSemaphore.release();
            ;
        }
    }

    private static void finishRoad(int index) {
        System.out.println("Car " + index + " at the finish line");
        randomSleepTime();
        System.out.println("Car " + index + " finished the race");
    }
}

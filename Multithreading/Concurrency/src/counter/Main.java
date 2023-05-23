package counter;

public class Main {
    private static final int LIMIT = 100_000_000;

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        long before = System.currentTimeMillis();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < LIMIT; i++) {
                counter.increment();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < LIMIT; i++) {
                counter.decrement();
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        long after = System.currentTimeMillis();

        System.out.println("Value: " + counter.getValue());
        System.out.println("Time: " + (after - before));
    }
}

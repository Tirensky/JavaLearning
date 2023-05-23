package fillarrays;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int LIMIT = 1_000_000;

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        long before = System.currentTimeMillis();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < LIMIT; i++) {
                list1.add(i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < LIMIT; i++) {
                list2.add(i);
            }
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < LIMIT; i++) {
                list3.add(i);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        long after = System.currentTimeMillis();
        System.out.println("Time: " + (after - before));

        System.out.println(list1.size());
        System.out.println(list2.size());
        System.out.println(list3.size());
    }
}

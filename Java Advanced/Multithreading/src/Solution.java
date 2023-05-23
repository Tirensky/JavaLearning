import java.util.Random;

public class Solution {
    public static boolean isTarget = false;
    public static final int BOUND = 1_000_000_000;

    public static void main(String[] args) {
        Random rnd = new Random();
        int target = rnd.nextInt(BOUND);
        System.out.println("Target number: " + target);

        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                int seconds = 0;
                try {
                    while (!isTarget) {
                        System.out.println(seconds++);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread guesser = new Thread(new Runnable() {
            @Override
            public void run() {
                int generated = 0;
                while (!isTarget) {
                    generated = rnd.nextInt(BOUND);
                    if (generated == target) isTarget = true;
                }
                System.out.println("Found it: " + generated);
            }
        });

        timer.start();
        guesser.start();
    }
}

package blocking;

public class Solution {
    private static String nextLetter = "A";
    private static final Object MONITOR = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (MONITOR) {
                for (int i = 0; i < 5; i++) {
                    try {
                        while (!nextLetter.equals("A")) MONITOR.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.print("A");
                    nextLetter = "B";
                    MONITOR.notifyAll();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (MONITOR) {
                for (int i = 0; i < 5; i++) {
                    try {
                        while (!nextLetter.equals("B")) MONITOR.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.print("B");
                    nextLetter = "C";
                    MONITOR.notifyAll();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (MONITOR) {
                for (int i = 0; i < 5; i++) {
                    try {
                        while (!nextLetter.equals("C")) MONITOR.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.print("C");
                    nextLetter = "A";
                    MONITOR.notifyAll();
                }
            }
        }).start();

    }
}

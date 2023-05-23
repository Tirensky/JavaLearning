package timer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start of " + Thread.currentThread().getName());

        Thread thread = new Thread(() -> {
            try {
                for (int i = 0; i < 1000; i++) {
                    if (Thread.currentThread().isInterrupted()) break;
                    System.out.print(i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();

        Thread.sleep(1000);

        for (int i = 0; i < 1000; i++) {
            if (i >= 100) thread.interrupt();
            System.out.print("M");
        }

        System.out.println("\nEnd of " + Thread.currentThread().getName());
    }
}

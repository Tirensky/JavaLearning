package thread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start of " + Thread.currentThread().getName());

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                // if flag is 'true', then exit from loop
                if (Thread.currentThread().isInterrupted()) break;
                System.out.print(i);
            }
        });
        thread.start();

        for (int i = 0; i < 1000; i++) {
            // set flag 'true' to thread by condition 'i >= 100'
            if (i >= 100) thread.interrupt();
            System.out.print("M");
        }

        System.out.println("\nEnd of " + Thread.currentThread().getName());
    }
}

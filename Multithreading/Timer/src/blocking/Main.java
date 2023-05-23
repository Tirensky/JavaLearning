package blocking;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue blockingQueue = new MyBlockingQueue();

        new Thread(() -> {
            int count = 0;
            while (true) {
                System.out.println("Counter: " + count++);
                Runnable task;
                try {
                    task = blockingQueue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (task != null) new Thread(task).start();
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            Thread.sleep(700);
            blockingQueue.add(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(">>> " + index);
            });
        }
    }
}

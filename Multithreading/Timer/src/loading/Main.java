package loading;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(3, r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });

        // loading bar imitation
        executors.execute(() -> {
            try {
                while (true) {
                    System.out.print(".");
                    Thread.sleep(450);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Future<String> futureName = executors.submit(() -> {
            Thread.sleep(5000);
            return "Olga";
        });
        Future<Integer> futureAge = executors.submit(() -> {
            Thread.sleep(5000);
            return 28;
        });

        String name = futureName.get();
        int age = futureAge.get();

        System.out.println("\n" + name + ", " + age + " y.o.");
    }
}

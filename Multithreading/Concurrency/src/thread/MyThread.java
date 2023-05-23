package thread;

public class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.print(i);
        }
    }
}

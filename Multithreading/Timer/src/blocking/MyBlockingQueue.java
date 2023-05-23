package blocking;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue {
    private final Queue<Runnable> queue = new LinkedList<>();
    private final Object monitor = new Object();

    public void add(Runnable task) {
        synchronized (monitor) {
            queue.add(task);
            monitor.notifyAll();
        }
    }

    public Runnable take() throws InterruptedException {
        synchronized (monitor) {
            while (queue.isEmpty()) monitor.wait();
            return queue.poll();
        }
    }
}

package counter;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger value;

    public Counter() {
        value = new AtomicInteger();
    }

    public void increment() {
        value.getAndIncrement();
    }

    public void decrement() {
        value.getAndDecrement();
    }

    public int getValue() {
        return value.intValue();
    }
}

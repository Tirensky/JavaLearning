package example.collection.queue;

import example.Car;
import example.collection.list.JLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarQueueTest {
    JQueue<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new JLinkedList<>();
        for (int i = 0; i < 10; i++) {
            cars.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void testAddingElement() {
        assertEquals(10, cars.size());
    }

    @Test
    public void testPeekingElement() {
        Car first = cars.peek();
        assertEquals("Brand0", first.getBrand());
        assertEquals(10, cars.size());
    }

    @Test
    public void testRemovingElement() {
        Car removed = cars.remove();
        assertEquals("Brand0", removed.getBrand());
        assertEquals(9, cars.size());
    }

    @Test
    public void testPollingElement() {
        Car removed = cars.poll();
        assertEquals("Brand0", removed.getBrand());
        assertEquals(9, cars.size());
    }
}
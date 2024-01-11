package base.collection;

import base.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class JQueueTest {
    private JQueue<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new JLinkedList<>();
        for (int i = 0; i < 10; i++) {
            cars.add(new Car("Brand" + i, i));
        }
    }

    @Test
    void testRemovingExistentElementFromQueueShouldReturnRightValueAndDecreaseSizeOfQueue() {
        Car car = cars.remove();
        assertEquals("Brand0", car.getBrand());
        assertEquals(9, cars.size());
    }

    @Test
    void testRemovingElementFromEmptyQueueShouldThrowNoSuchElementException() {
        for (int i = 0; i < 10; i++) {
            cars.remove();
        }
        assertThrows(NoSuchElementException.class, () -> cars.remove());
    }

    @Test
    void testPeekingExistentElementFromQueueShouldReturnRightValue() {
        Car car = cars.peek();
        assertEquals("Brand0", car.getBrand());
        assertEquals(10, cars.size());
    }

    @Test
    void testPeekingFromEmptyQueueShouldReturnNull() {
        for (int i = 0; i < 10; i++) {
            cars.remove();
        }
        assertNull(cars.peek());
    }

    @Test
    void testPollingExistentElementFromQueueShouldReturnRightValueAndDecreaseSizeOfQueue() {
        Car car = cars.poll();
        assertEquals("Brand0", car.getBrand());
        assertEquals(9, cars.size());
    }

    @Test
    void testPollingFromEmptyQueueShouldReturnNull() {
        for (int i = 0; i < 10; i++) {
            cars.remove();
        }
        assertNull(cars.poll());
    }
}
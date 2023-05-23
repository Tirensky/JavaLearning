package example.collection.set;

import example.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarSetTest {
    private JSet<Car> cars;

    @BeforeEach
    public void setUp() {
        cars = new JHashSet<>();
        for (int i = 0; i < 100; i++) {
            cars.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void testAdding100DifferentElementsShouldIncreaseSizeBy100() {
        assertEquals(100, cars.size());
    }

    @Test
    public void testAdding100ElementsWith10DifferentValuesShouldIncreaseSizeBy10() {
        for (int i = 0; i < 100; i++) {
            int index = i % 10;
            cars.add(new Car("Similar" + index, index));
        }
        assertEquals(110, cars.size());
    }

    @Test
    public void testAdding3SimilarElementsShouldIncreaseSizeBy1() {
        assertTrue(cars.add(new Car("BMW", 42)));
        assertFalse(cars.add(new Car("BMW", 42)));
        assertFalse(cars.add(new Car("BMW", 42)));
        assertEquals(101, cars.size());
    }

    @Test
    public void testRemovingExistentElementShouldDecreaseSizeBy1() {
        assertTrue(cars.remove(new Car("Brand9", 9)));
        assertEquals(99, cars.size());
    }

    @Test
    public void testRemovingNonExistentElementShouldReturnFalse() {
        Car car = new Car("TryToRemoveTwice", 888);
        cars.add(car);
        assertEquals(101, cars.size());
        assertTrue(cars.remove(car));
        assertFalse(cars.remove(car));
        assertEquals(100, cars.size());
    }

    @Test
    public void testSetShouldBeEmptyAfterClearing() {
        cars.clear();
        assertEquals(0, cars.size());
    }
}
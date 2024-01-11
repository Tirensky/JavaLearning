package base.collection;

import base.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JSetTest {
    private JSet<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new JHashSet<>();
        for (int i = 0; i < 100; i++) {
            cars.add(new Car("Brand" + i, i));
        }
    }

    @Test
    void testAdding100DifferentElementsShouldIncreaseSizeBy100() {
        assertEquals(100, cars.size());
    }

    @Test
    void testAddingSimilarElementsShouldIncreaseSizeBy1() {
        assertTrue(cars.add(new Car("Foame", 27)));
        assertFalse(cars.add(new Car("Foame", 27)));
        assertFalse(cars.add(new Car("Foame", 27)));
        assertFalse(cars.add(new Car("Foame", 27)));
        assertEquals(101, cars.size());
    }

    @Test
    void testRemovingExistentElementShouldReturnTrueAndDecreaseSizeBy1() {
        assertTrue(cars.remove(new Car("Brand44", 44)));
        assertEquals(99, cars.size());
    }

    @Test
    void testRemovingNonExistentElementShouldReturnFalse() {
        Car nonExistentAfterRemoved = new Car("TryToRemoveTwice", 2);
        assertTrue(cars.add(nonExistentAfterRemoved));
        assertTrue(cars.remove(nonExistentAfterRemoved));
        assertFalse(cars.remove(nonExistentAfterRemoved));
        assertEquals(100, cars.size());
    }

    @Test
    void testSetShouldBeEmptyAfterClearing() {
        cars.clear();
        assertEquals(0, cars.size());
    }

    @Test
    void testFindingElementInTheSet() {
        assertTrue(cars.contains(new Car("Brand23", 23)));
        assertFalse(cars.contains(new Car("NewBrand23", 23)));
    }

    @Test
    void testIteratingForEachElements() {
        int count = 0;
        for (Car car : cars) {
            count++;
        }
        assertEquals(count, cars.size());
    }
}
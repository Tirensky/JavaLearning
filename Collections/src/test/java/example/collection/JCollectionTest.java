package example.collection;

import example.Car;
import example.collection.list.JArrayList;
import example.collection.list.JLinkedList;
import example.collection.set.JHashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JCollectionTest {
    private JCollection<Car> cars;

    @BeforeEach
    public void setUp() {
        cars = new JHashSet<>();
        for (int i = 0; i < 10; i++) {
            cars.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void testListContainsElement() {
        Car existent = new Car("Brand5", 5);
        Car nonExistent = new Car("FindMe", 14);
        assertTrue(cars.contains(existent));
        assertFalse(cars.contains(nonExistent));
    }

    @Test
    public void testForEachLoop() {
        int counter = 0;
        for (Car car : cars) {
            counter++;
        }
        assertEquals(counter, cars.size());
    }
}
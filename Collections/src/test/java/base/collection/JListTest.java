package base.collection;

import base.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JListTest {
    private JList<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new JLinkedList<>();
        for (int i = 0; i < 100; i++) {
            cars.add(new Car("Brand" + i, i));
        }
    }

    /**
     * Rules: first 'test' than 'what we're checking'
     * <br>
     * Example: testAddingElementsToCollectionShouldIncreaseSizeOfIt or testSomeMethod
     */
    @Test
    void testGetMethod() {
        Car car50 = cars.get(50);
        assertEquals("Brand50", car50.getBrand());
    }

    @Test
    void testThrowingIndexOutOfBoundExceptionWhenGetWrongElement() {
        assertThrows(IndexOutOfBoundsException.class, () -> cars.get(100));
    }

    @Test
    void testAdding100ElementsToListShouldIncreaseSizeBy100() {
        assertEquals(100, cars.size());
    }

    @Test
    void testAddingElementToHeadOfList() {
        Car car = new Car("Labmo", 69);
        assertTrue(cars.add(car, 0));
        assertTrue(cars.add(car, 0));
        assertEquals(102, cars.size());
    }

    @Test
    void testAddingElementToMiddleOfList() {
        Car car = new Car("Labmo", 69);
        assertTrue(cars.add(car, 49));
        assertTrue(cars.add(car, 50));
        assertTrue(cars.add(car, 51));
        assertEquals(103, cars.size());
    }

    @Test
    void testAddingElementToEndOfList() {
        Car car = new Car("Labmo", 69);
        assertTrue(cars.add(car, 100));
        assertTrue(cars.add(car, 101));
        assertEquals(102, cars.size());
    }

    @Test
    void testRemovingExistentElementShouldDecreaseSize() {
        Car existent = new Car("Brand10", 10);
        assertTrue(cars.remove(existent));
        assertEquals(99, cars.size());
    }

    @Test
    void testRemovingNonExistentElementShouldNotDecreaseSize() {
        Car nonExistentAfterRemoved = new Car("Brand9", 9);
        assertTrue(cars.remove(nonExistentAfterRemoved));
        assertEquals(99, cars.size());
        assertFalse(cars.remove(nonExistentAfterRemoved));
        assertEquals(99, cars.size());
    }

    @Test
    void testRemovingElementByIndexShouldDecreaseSize() {
        assertTrue(cars.remove(5));
        assertEquals(99, cars.size());
    }

    @Test
    void testIndexOutOfBoundExceptionWhenRemoveWrongElement() {
        assertThrows(IndexOutOfBoundsException.class, () -> cars.remove(100));
    }

    @Test
    void testListShouldBeEmptyAfterClearing() {
        cars.clear();
        assertEquals(0, cars.size());
    }

    @Test
    void testFindingElementInTheList() {
        assertTrue(cars.contains(new Car("Brand12", 12)));
        assertFalse(cars.contains(new Car("NewBrand12", 12)));
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
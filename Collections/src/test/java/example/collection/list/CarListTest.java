package example.collection.list;

import example.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarListTest {
    private JList<Car> cars;

    @BeforeEach
    public void setUp() {
        cars = new JLinkedList<>();
        for (int i = 0; i < 100; i++) {
            cars.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void testAdding100ElementsShouldIncreaseSizeBy100() {
        assertEquals(100, cars.size());
    }

    @Test
    public void testRemoving1ElementByIndexShouldDecreaseSizeBy1() {
        assertTrue(cars.remove(0));
        assertEquals(99, cars.size());
    }

    @Test
    public void testRemoving1ElementShouldDecreaseSizeBy1() {
        Car temporal = new Car("Brand6", 6);
        assertTrue(cars.remove(temporal));
        assertEquals(99, cars.size());
    }

    @Test
    public void testRemovingNonExistentElementShouldReturnFalse() {
        Car tryToRemoveTwice = cars.get(50);
        assertTrue(cars.remove(tryToRemoveTwice));
        assertEquals(99, cars.size());
        assertFalse(cars.remove(tryToRemoveTwice));
        assertEquals(99, cars.size());
    }

    @Test
    public void testListShouldBeEmptyAfterClearing() {
        cars.clear();
        assertEquals(0, cars.size());
    }

    @Test
    public void testGetMethodShouldReturnRightValue() {
        String expected = "Brand80";
        String actual = cars.get(80).getBrand();
        assertEquals(expected, actual);
    }

    @Test
    public void testThrowingIndexOutOfBoundExceptionWhenGetWrongElement() {
        boolean wasException = false;
        try {
            cars.get(100);
        } catch (IndexOutOfBoundsException e) {
            wasException = true;
        }
        assertTrue(wasException);
    }

    @Test
    public void testThrowingIndexOutOfBoundExceptionWhenRemoveWrongElement() {
        boolean wasException = false;
        try {
            cars.remove(100);
        } catch (IndexOutOfBoundsException e) {
            wasException = true;
        }
        assertTrue(wasException);
    }

    @Test
    public void testAddingElementToHeadOfList() {
        Car car = new Car("BMW", 42);
        assertTrue(cars.add(car, 0));
        assertEquals(101, cars.size());
        Car alreadyAdded = cars.get(0);
        assertEquals("BMW", alreadyAdded.getBrand());
    }

    @Test
    public void testAddingElementToMiddleOfList() {
        Car car = new Car("BMW", 42);
        assertTrue(cars.add(car, 50));
        assertEquals(101, cars.size());
        Car alreadyAdded = cars.get(50);
        assertEquals("BMW", alreadyAdded.getBrand());
    }

    @Test
    public void testAddingElementToEndOfList() {
        Car car = new Car("BMW", 42);
        assertTrue(cars.add(car, 100));
        assertEquals(101, cars.size());
        Car alreadyAdded = cars.get(100);
        assertEquals("BMW", alreadyAdded.getBrand());
    }
}
package base.map;

import base.Car;
import base.CarOwner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JMapTest {
    private JMap<CarOwner, Car> owners;

    @BeforeEach
    void setUp() {
        owners = new JHashMap<>();
        for (int i = 0; i < 100; i++) {
            owners.put(new CarOwner("FirstName" + i, "LastName" + i, i),
                       new Car("Brand" + i, i));
        }
    }

    @Test
    void testPuttingElementWithNewKeyShouldReturnRightValue() {
        Car car = owners.put(new CarOwner( "Alex", "Jonson", 33),
                new Car("Bugatti", 99));
        assertEquals("Bugatti", car.getBrand());
        assertEquals(101, owners.size());
    }

    @Test
    void testPuttingElementWithExistentKeyShouldReturnNull() {
        Car car = owners.put(new CarOwner( "FirstName4", "LastName4", 4),
                new Car("Bugatti", 99));
        assertNull(car);
        assertEquals(100, owners.size());
    }

    @Test
    void testAdding100ElementsWith100DifferentKeysShouldIncreaseSizeBy100() {
        assertEquals(100, owners.size());
    }

    @Test
    void testGetMethod() {
        Car existentValue = owners.get(new CarOwner("FirstName3", "LastName3", 3));
        assertEquals("Brand3", existentValue.getBrand());
    }

    @Test
    void testAdding100ElementsWith10DifferentKeysShouldIncreaseSizeBy10() {
        for (int i = 0; i < 100; i++) {
            int index = i % 10;
            owners.put(new CarOwner("NewFirstName" + index, "NewLastName" + index, index),
                    new Car("Brand" + i, i));
        }
        assertEquals(110, owners.size());
    }

    @Test
    void testKeySetSizeShouldBeEqualsToValuesListSize() {
        assertEquals(100, owners.keySet().size());
        assertEquals(owners.keySet().size(), owners.values().size());
    }

    @Test
    void testRemovingExistentElementShouldDecreaseSizeAndReturnValue() {
        CarOwner existentKey = new CarOwner("FirstName43", "LastName43", 43);
        Car removed = owners.remove(existentKey);
        assertEquals("Brand43", removed.getBrand());
        assertEquals(99, owners.size());
        owners.remove(existentKey);
        assertEquals(99, owners.size());
    }

    @Test
    void testMapShouldBeEmptyAfterClearing() {
        owners.clear();
        assertEquals(0, owners.size());
    }

    @Test
    void testFindingElementInTheMap() {
        CarOwner existentKey = new CarOwner("FirstName43", "LastName43", 43);
        assertTrue(owners.containsKey(existentKey));
    }
}
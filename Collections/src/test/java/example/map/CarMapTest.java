package example.map;

import example.Car;
import example.CarOwner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarMapTest {
    private JMap<CarOwner, Car> owners;

    @BeforeEach
    void setUp() {
        owners = new JHashMap<>();
        for (int i = 0; i < 100; i++) {
            CarOwner k = new CarOwner(i, "Name" + i, "Lastname" + i);
            Car v = new Car("Brand" + i, i);
            owners.put(k, v);
        }
    }

    @Test
    public void testPutting100DifferentElementsShouldIncreaseSizeBy100() {
        assertEquals(100, owners.size());
    }

    @Test
    public void testPutting100ElementsWith10DifferentKeysShouldIncreaseSizeBy10() {
        for (int i = 0; i < 100; i++) {
            int index = i % 10;
            CarOwner k = new CarOwner(index, "NewName" + index, "NewLastname" + index);
            Car v = new Car("NewBrand" + i, i);
            owners.put(k, v);
        }
        assertEquals(110, owners.size());
    }

    @Test
    public void testKeySetSizeEqualsValuesListSize() {
        int keys = owners.keySet().size();
        int values = owners.values().size();
        assertEquals(keys, owners.size());
        assertEquals(values, owners.size());
    }

    @Test
    public void testRemovingExistentElementShouldDecreaseSize() {
        CarOwner unnecessary = new CarOwner(5, "Name5", "Lastname5");
        Car removed = owners.remove(unnecessary);
        assertEquals("Brand5", removed.getBrand());
        assertEquals(99, owners.size());
    }

    @Test
    public void testMapShouldBeEmptyAfterClearing() {
        owners.clear();
        assertEquals(0, owners.size());
    }

    @Test
    public void testGetMethodShouldReturnRightValue() {
        Car car = owners.get(new CarOwner(15, "Name15", "Lastname15"));
        String expectedBrand = "Brand15";
        String actualBrand = car.getBrand();
        assertEquals(expectedBrand, actualBrand);
    }
}
package base;

import java.util.Comparator;
import java.util.Objects;

public class Car implements Comparable<Car> {
    private String brand;
    private int serialID;

    public Car(String brand, int serialID) {
        setBrand(brand);
        setSerialID(serialID);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSerialID() {
        return serialID;
    }

    public void setSerialID(int serialID) {
        this.serialID = serialID;
    }

    @Override
    public String toString() {
        return brand + " (SerialNo.: " + serialID + ')';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return serialID == car.serialID && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, serialID);
    }

    @Override
    public int compareTo(Car o) {
        return brand.compareTo(o.brand);
    }

    public static Comparator<Car> compareById() {
        return Comparator.comparing(Car::getSerialID);
    }
}

package example;

import java.util.Objects;

public class Car {
    private String brand;
    private int serialID;

    public Car(String brand, int serialID) {
        setBrand(brand);
        setSerialID(serialID);
    }

    public final String getBrand() {
        return brand;
    }

    public final void setBrand(String brand) {
        this.brand = brand;
    }

    public final int getSerialID() {
        return serialID;
    }

    public final void setSerialID(int serialID) {
        this.serialID = serialID;
    }

    @Override
    public String toString() {
        return brand + " (" + serialID + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return serialID == car.serialID && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, serialID);
    }
}

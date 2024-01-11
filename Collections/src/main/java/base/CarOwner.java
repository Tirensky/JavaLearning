package base;

import java.util.Objects;

public class CarOwner implements Comparable<CarOwner> {
    private String firstName, lastName;
    private int id;

    public CarOwner(String firstName, String lastName, int id) {
        setFirstName(firstName);
        setLastName(lastName);
        setId(id);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "(ID: " + id + ") " + firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarOwner owner = (CarOwner) o;
        return Objects.equals(firstName, owner.firstName) &&
                Objects.equals(lastName, owner.lastName) && id == owner.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id);
    }

    @Override
    public int compareTo(CarOwner o) {
        return firstName.compareTo(o.firstName);
    }
}

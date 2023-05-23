package example;

import java.util.Objects;

public class CarOwner {
    private int id;
    private String name, lastname;

    public CarOwner(int id, String name, String lastname) {
        setID(id);
        setName(name);
        setLastname(lastname);
    }

    public final int getId() {
        return id;
    }

    public final void setID(int id) {
        this.id = id;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getLastname() {
        return lastname;
    }

    public final void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return name + " " + lastname + " (id: " + id + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarOwner carOwner = (CarOwner) o;
        return id == carOwner.id
                && Objects.equals(name, carOwner.name)
                && Objects.equals(lastname, carOwner.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname);
    }
}

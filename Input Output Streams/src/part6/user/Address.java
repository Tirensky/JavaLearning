package part6.user;

import java.io.Serializable;

public class Address implements Serializable {
    private String street;
    private int build;

    public Address() {
        this(null, 0);
    }

    public Address(String street, int build) {
        setStreet(street);
        setBuild(build);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuild() {
        return build;
    }

    public void setBuild(int build) {
        this.build = build;
    }

    @Override
    public String toString() {
        return build + " " + street;
    }
}

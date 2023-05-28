package part6.user;

import java.io.Serializable;

public class User extends Person implements Serializable {
    private int age;
    private Address address;

    public User() {
        this(null, null, 0, null);
    }

    public User(String firstname, String lastname, int age, Address address) {
        super(firstname, lastname);
        setAge(age);
        setAddress(address);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + age + " y.o. (" + address + ')';
    }
}

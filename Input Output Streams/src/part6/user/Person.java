package part6.user;

import java.io.Serializable;

public class Person implements Serializable {
    private String firstname, lastname;

    public Person() {
        this(null, null);
    }

    public Person(String firstname, String lastname) {
        setFirstname(firstname);
        setLastname(lastname);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }
}

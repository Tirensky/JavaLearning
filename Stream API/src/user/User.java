package user;

public class User {
    private String firstname;
    private int age;

    public User(String firstname, int age) {
        this.firstname = firstname;
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return firstname + ", " + age + " y.o.";
    }
}

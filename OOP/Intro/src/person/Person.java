package person;

public class Person {
    private String name;
    private int age;
    private float weight;

    public Person() {
        this(null, 0,0);
    }

    public Person(String name, int age, float weight) {
        setName(name);
        setAge(age);
        setWeight(weight);
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public final void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public final void setWeight(float weight) {
        this.weight = weight;
    }
}

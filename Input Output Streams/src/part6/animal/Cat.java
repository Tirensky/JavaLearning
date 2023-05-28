package part6.animal;

import java.io.Serializable;

public class Cat implements Serializable {
    private String name, breed;
    private float weight;

    public Cat() {
        this(null, null, 0);
    }

    public Cat(String name, String breed, float weight) {
        setName(name);
        setBreed(breed);
        setWeight(weight);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + " (" + breed + ", " + weight + "g)";
    }
}

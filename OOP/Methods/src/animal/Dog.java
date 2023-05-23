package animal;

public class Dog {
    private String name, breed;
    private int counter;

    public Dog() {
        this(null, null, 0);
    }

    public Dog(String name, String breed, int counter) {
        setName(name);
        setBreed(breed);
        setCounter(counter);
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public final void setBreed(String breed) {
        this.breed = breed;
    }

    public int getCounter() {
        return counter;
    }

    public final void setCounter(int counter) {
        this.counter = counter;
    }

    public void run() {
        System.out.print("Running, ");
        for (int i = 1; i < counter; i++) {
            System.out.print((i != counter - 1) ? "running, " : "running.\n");
        }
    }

    public String about() {
        return name + ", " + breed;
    }


}

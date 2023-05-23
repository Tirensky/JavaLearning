package worker;

public class Worker {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void about() {
        System.out.println("My name is " + name);
    }
}

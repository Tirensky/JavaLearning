package man;

public class Man {
    private String name, post;
    private int age;
    private double height;

    public Man(String name, String post, int age, double height) {
        this.name = name;
        this.post = post;
        this.age = age;
        this.height = height;
    }

    @Override
    public String toString() {
        return name + " (" + age + " y.o., " + height + "cm): " + post;
    }
}

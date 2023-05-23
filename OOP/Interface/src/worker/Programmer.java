package worker;

public class Programmer extends Worker implements Programmable {
    public Programmer(String name) {
        super(name);
    }

    @Override
    public void writeCode() {
        System.out.println(getName() + " can write a code.");
    }
}

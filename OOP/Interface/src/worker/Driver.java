package worker;

public class Driver extends Worker implements Drivable {
    public Driver(String name) {
        super(name);
    }

    @Override
    public void drive() {
        System.out.println(getName() + " can drive a car.");
    }
}

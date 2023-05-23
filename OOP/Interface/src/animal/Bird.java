package animal;

public class Bird extends Animal implements RunnableAnimal, FlyableAnimal {
    @Override
    void eat() {
        System.out.println("Eat bread crumbs");
    }

    @Override
    public void run() {
        System.out.println("Bird is running!");
    }

    @Override
    public void fly() {
        System.out.println("Bird is flying!");
    }
}

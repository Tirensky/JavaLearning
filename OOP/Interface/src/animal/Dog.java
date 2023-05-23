package animal;

public class Dog extends Animal implements RunnableAnimal {
    @Override
    void eat() {
        System.out.println("Eat cats");
    }

    @Override
    public void run() {
        System.out.println("Dog is running!");
    }
}

package animal;

public class Cat extends Animal implements RunnableAnimal {
    @Override
    void eat() {
        System.out.println("Eat birds");
    }

    @Override
    public void run() {
        System.out.println("Cat is running!");
    }
}

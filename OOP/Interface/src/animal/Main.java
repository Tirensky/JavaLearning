package animal;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();

        Cat cat1 = new Cat();
        Cat cat2 = new Cat();

        Fish fish1 = new Fish();
        Fish fish2 = new Fish();

        Bird bird1 = new Bird();
        Bird bird2 = new Bird();

        List<Animal> animals = new ArrayList<>();
        animals.add(dog1);
        animals.add(cat2);
        animals.add(fish1);
        animals.add(bird2);

        for (Animal animal : animals) {
            animal.eat();
        }

        // upcast
        Animal animal = fish2;
        // downcast
        fish2 = (Fish) animal;

        List<RunnableAnimal> runnableAnimals = new ArrayList<>();
        runnableAnimals.add(dog2);
        runnableAnimals.add(cat1);
        runnableAnimals.add(bird1);

        for (RunnableAnimal runnableAnimal : runnableAnimals) {
            runnableAnimal.run();
        }
    }
}

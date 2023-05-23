package animal;

public class Lion extends CatFamily {
    @Override
    public void eat() {
        super.eat();
        System.out.println("antelope");
    }
}

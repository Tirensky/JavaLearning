package worker;

public class Chef extends Worker implements Cookable {
    public Chef(String name) {
        super(name);
    }

    @Override
    public void cook() {
        System.out.println(getName() + " can cook food.");
    }
}

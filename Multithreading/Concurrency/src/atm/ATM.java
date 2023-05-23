package atm;

public class ATM {
    private final Object monitor = new Object();
    private int amount;

    public ATM(int amount) {
        this.amount = amount;
    }

    public void withdraw(User user, int amount) throws InterruptedException {
        synchronized (monitor) {
            // check user authorize
            if (!user.logIn()) {
                Thread.sleep(2000);
                System.out.println("Access not allowed!");
                return;
            }

            System.out.printf("Hello, %s!\n", user.getName());
            Thread.sleep(2000);

            if (amount <= this.amount) {
                this.amount -= amount;
                System.out.printf("Hey %s, you just cashed out $%s. :)\n", user.getName(), amount);
            } else {
                System.out.println("Not enough funds to withdraw. :(");
            }
            if (user.isAdmin()) System.out.println("ATM has: $" + this.amount);
            Thread.sleep(800);
        }
    }
}

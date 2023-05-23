package atm;

public class Solution {
    public static void main(String[] args) {
        ATM atm = new ATM(5000);

        User user1 = new User("Charlie");
        User user2 = new User("Jane");
        User user3 = new User("Shawn");
        User user4 = new User("Andy");

        client(atm, user1, 2050, true).start();
        client(atm, user2, 1250, true).start();
        client(atm, user3, 500, false).start();
        client(atm, user4, 1750, false).start();
    }

    private static Thread client(ATM atm, User user, int amount, boolean access) {
        return new Thread(() -> {
            user.sighUp();
            user.setAdminAllow(access);
            try {
                atm.withdraw(user, amount);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

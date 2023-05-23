package account;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(1000, 1000);

        new Thread(() -> {
            try {
                account.transferToNewDebit(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                account.transferToOldDebit(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }
}

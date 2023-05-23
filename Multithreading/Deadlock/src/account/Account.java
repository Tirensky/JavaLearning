package account;

public class Account {
    private int debit1;
    private int debit2;

    private static final Object MONITOR_1 = new Object();
    private static final Object MONITOR_2 = new Object();

    public Account(int debit1, int debit2) {
        this.debit1 = debit1;
        this.debit2 = debit2;
    }

    public void transferToNewDebit(int amount) throws InterruptedException {
        transferTo(MONITOR_1, debit1, MONITOR_2, debit2, amount);
    }

    public void transferToOldDebit(int amount) throws InterruptedException {
        transferTo(MONITOR_2, debit2, MONITOR_1, debit1, amount);
    }

    private void transferTo(Object outer, int from,
                           Object inner, int to, int amount) throws InterruptedException {
        synchronized (outer) {
            Thread.sleep(1800);
            if (amount <= from) {
                System.out.println("DONE");
                synchronized (inner) {
                    Thread.sleep(1800);
                    from -= amount;
                    to += amount;
                }
            } else {
                System.out.println("Insufficient funds");
            }
        }
    }
}

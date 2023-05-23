package mfp;

public class MFPrinter {
    private int pages;

    private static final Object PRINTED = new Object();
    private static final Object SCANNED = new Object();

    public MFPrinter(int pages) {
        this.pages = pages;
    }

    public void print(int nPages) throws InterruptedException {
        synchronized (PRINTED) {
            for (int i = 1; i <= nPages; i++) {
                pages--;
                Thread.sleep(470);
                System.out.println("Printed " + i + " page(s).");
            }

        }
    }

    public void scan(int nPages) throws InterruptedException {
        synchronized (SCANNED) {
            for (int i = 1; i <= nPages; i++) {
                Thread.sleep(470);
                System.out.println("Scanned " + i + " page(s).");
            }
        }
    }

    public int getPages() {
        return pages;
    }
}

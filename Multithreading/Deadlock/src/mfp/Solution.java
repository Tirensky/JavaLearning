package mfp;

import java.util.concurrent.CountDownLatch;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        MFPrinter mfp = new MFPrinter(400);
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(() -> {
            try {
                mfp.print(40);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            try {
                mfp.scan(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();

        System.out.println("Pages left: " + mfp.getPages());
    }
}

public class Main {
    public static boolean isMinutes = false;

    public static void main(String[] args) {
        Thread timer = new Thread(() -> {
            int seconds = 0;
            int minutes = 0;
            try {
                while (!isMinutes) {
                    System.out.println(minutes + " : " + seconds++);
                    Thread.sleep(1000);
                    if (seconds == 5) {
                        minutes++;
                        isMinutes = true;
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        timer.start();
        Thread player = new Thread(() -> {
            int seconds = 0;
            try {
                while (!isMinutes) {
                    System.out.println(seconds++);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        player.start();
    }
}
public class Main {
    public static void main(String[] args) {
        int i1 = 2;
        int[] array = new int[1];
        try {
            int i2 = 7 / i1;
            String s = "12";
            int i3 = Integer.parseInt(s);
            System.out.println(array[1]);
        } catch (ArithmeticException | NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Exception! " + e.getMessage());
        } finally {
            System.out.println("Its always print by 'finally'");
        }
        System.out.println("You are here");
    }
}
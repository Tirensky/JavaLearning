package part4;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        File directory = new File("src/part4/");
        File file1 = new File(directory, "names.txt");

        directory.mkdirs();
        file1.createNewFile();

        try (Scanner scanner = new Scanner(System.in);
             OutputStream outputStream = new FileOutputStream(file1, true);
             Reader reader = new InputStreamReader(new FileInputStream(file1))) {
            System.out.print("Enter name or 'stop' to exit: ");
            String name = scanner.nextLine();
            while (!name.equals("stop")) {
                outputStream.write(name.getBytes());
                outputStream.write(" ".getBytes());
                System.out.print("Enter name or 'stop' to exit: ");
                name = scanner.nextLine();
            }

            int oByte = reader.read();
            System.out.println("Names:");
            while (oByte != -1) {
                System.out.print((char) oByte);
                oByte = reader.read();
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }
}

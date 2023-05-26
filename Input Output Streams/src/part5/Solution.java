package part5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        File directory = new File("src/part5/");
        File file = new File(directory, "text.txt");

        directory.mkdirs();
        file.createNewFile();

        try (RandomAccessFile raf = new RandomAccessFile(file, "r");
             Scanner scanner = new Scanner(System.in)) {
            System.out.print("Select page: ");
            int page = scanner.nextInt();
            byte[] array = new byte[1024];
            while (page >= 0) {
                raf.seek((page - 1) * array.length);
                raf.read(array);
                System.out.println(new String(array));
                System.out.print("Select page: ");
                page = scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package part2;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File directory = new File("src/part2/");
        File file1 = new File(directory, "test1.txt");

        directory.mkdirs();
        file1.createNewFile();

        try (InputStream inputStream = new FileInputStream(file1)) {
            int oByte = inputStream.read();
            while (oByte != -1) {
                System.out.print((char) oByte);
                oByte = inputStream.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

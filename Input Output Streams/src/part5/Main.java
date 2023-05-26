package part5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    public static void main(String[] args) throws IOException {
        File directory = new File("src/part5/");
        File file1 = new File(directory, "text.txt");

        directory.mkdirs();
        file1.createNewFile();

        try (RandomAccessFile raf = new RandomAccessFile(file1, "rw")) {
            raf.seek(0);
            byte[] array = new byte[1024];
            raf.read(array);
            System.out.println(new String(array));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

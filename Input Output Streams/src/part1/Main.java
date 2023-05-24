package part1;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File directory = new File("src/part1/");
        File file1 = new File(directory, "test1.txt");
        File file2 = new File(directory, "test2.txt");
        File file3 = new File(directory, "test3.txt");

        directory.mkdirs();
        file1.createNewFile();
        file2.createNewFile();
        file3.createNewFile();

        File[] files = directory.listFiles((dir, name) -> name.contains(".txt"));
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}

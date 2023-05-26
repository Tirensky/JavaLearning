package part3;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File directory = new File("src/part3/");
        File file1 = new File(directory, "text.txt");

        directory.mkdirs();
        file1.createNewFile();

        // if we need to read symbols instead bytes
        try (Reader reader = new InputStreamReader(new FileInputStream(file1))) {
            long before = System.currentTimeMillis();

//            byte[] array = new byte[8192];
            int bytes = reader.read();
            StringBuilder sb = new StringBuilder();
            while (bytes > 0) {
//                sb.append(new String(array, 0, bytes));
                sb.append((char) bytes);
                bytes = reader.read();
            }
            System.out.println(sb);

            long after = System.currentTimeMillis();
            System.out.println("Time: " + (after - before) + " ms");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

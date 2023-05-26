package part4;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File directory = new File("src/part4/");
        File file1 = new File(directory, "text.txt");

        directory.mkdirs();
        file1.createNewFile();

//        try (OutputStream outputStream = new FileOutputStream(file1, true)) {
//            String string = "Roman Max Nick Andrew Alex Helena Marrie\n";
//            outputStream.write(string.getBytes());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file1))) {
            long before = System.currentTimeMillis();

            StringBuilder sb = new StringBuilder();
            int oByte = inputStream.read();
            while (oByte != -1) {
                sb.append((char) oByte);
                oByte = inputStream.read();
            }

            long after = System.currentTimeMillis();
            System.out.println("Time: " + (after - before) + " ms");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

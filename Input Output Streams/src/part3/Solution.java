package part3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        File directory = new File("src/part3/");
        File file1 = new File(directory, "names.txt");

        directory.mkdirs();
        file1.createNewFile();

        try (Reader reader = new InputStreamReader(new FileInputStream(file1))) {
            StringBuilder sb = new StringBuilder();
            int oByte = reader.read();
            // adding each char to String Builder object
            while (oByte != -1) {
                sb.append((char) oByte);
                oByte = reader.read();
            }

            List<String> names = new ArrayList<>();
            for (int i = 0; i < sb.length();) {
                String name = "";
                // add to 'name' any chars except whitespaces
                while (!Character.isWhitespace(sb.charAt(i))) {
                    name += sb.charAt(i);
                    if (i < sb.length() - 1) i++;
                    else break;
                }
                names.add(name);
                i++;
            }

            names.stream()
                    .filter(name -> name.endsWith("a"))
                    .forEach(System.out::println);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

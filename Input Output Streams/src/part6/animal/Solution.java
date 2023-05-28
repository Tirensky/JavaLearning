package part6.animal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Biber", "Russian-blue", 4525.3f));
        cats.add(new Cat("Chewie", "Egyptian", 5201.8f));
        cats.add(new Cat("Gast", "Chubby", 4443f));

        File directory = new File("src/part6/animal/");
        File file = new File(directory, "cats.txt");

        directory.mkdirs();
        file.createNewFile();

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(cats);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            List<Cat> catList = (List<Cat>) inputStream.readObject();
            for (Cat cat : catList) {
                System.out.println(cat.getName());
            }
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

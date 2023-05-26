package part6;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setFirstname("Jack");
        user.setLastname("Marlie");
        user.setAge(25);
        user.setAddress(new Address("Main", 42));

        File directory = new File("src/part6/");
        File file = new File(directory, "users.txt");

        directory.mkdirs();
        file.createNewFile();

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(user); // use serializable class
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            // deserializing object
            User oUser = (User) inputStream.readObject();
            System.out.println(oUser);
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

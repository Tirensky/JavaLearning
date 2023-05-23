import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*String[] employees = {
                "Alex",
                "Richard",
                "Sindy",
                "Helen",
                "Max"
        };

        String[] increasedEmployees = new String[employees.length + 1];
        for (int i = 0; i < employees.length; i++) {
            increasedEmployees[i] = employees[i];
        }
        increasedEmployees[increasedEmployees.length - 1] = "Ivan";
        employees = increasedEmployees;

        employees[1] = null;
        String[] decreasedEmployees = new String[employees.length - 1];
        for (int i = 0, j = 0; i < employees.length; i++) {
            if (employees[i] != null) decreasedEmployees[j++] = employees[i];
        }
        employees = decreasedEmployees;
        printArray(employees);*/

        List<String> employees = new ArrayList<>();
        employees.add("Alex");
        employees.add("Richard");
        employees.add("Sindy");
        employees.add("Helen");
        employees.add("Max");

        for (String employee : employees) {
            System.out.println(employee);
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            numbers.add(i);
        }

        for (int number : numbers) {
            System.out.println(number);
        }
    }

    private static void printArray(String[] array) {
        for (String str : array)
            System.out.println(str);
    }
}

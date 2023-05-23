package list;

public class Solution {
    public static void main(String[] args) {
        MyArrayList employees = new MyArrayList();

        employees.add("Alex");
        employees.add("Richard");
        employees.add("Sindy");
        employees.add("Helen");
        employees.add("Max");

        employees.remove(3); // removes Helen
        employees.remove("Max"); // removes Max

        System.out.println(employees + " (size " + employees.size() + ')');
        System.out.println(employees.get(0)); // gets Alex
    }
}

package employee;

public class Solution {
    public static void main(String[] args) {
        Employee employee = new Employee("Bob", "DevOps", 5400);
        System.out.println(employee.about(7));
    }
}

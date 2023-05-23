package employee;

public class Employee {
    private String name, post;
    private int salary;

    public Employee(String name, String post, int salary) {
        this.name = name;
        this.post = post;
        this.salary = salary;
    }

    public String about(int months) {
        return name + "'s salary for " + months + " month(s): $" + (salary * months);
    }
}

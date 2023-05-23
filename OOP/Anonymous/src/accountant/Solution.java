package accountant;

public class Solution {
    public static void main(String[] args) {
        Director director = new Director();
        String report = director.force(new Accountant() {
            @Override
            public String report(int nMonths) {
                return "Report for " + nMonths + " month(s)";
            }
        }, 8);
        System.out.println(report);
    }
}

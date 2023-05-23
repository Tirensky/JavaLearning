package worker;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Programmer programmer1 = new Programmer("Jane");
        Programmer programmer2 = new Programmer("Chris");

        Driver driver1 = new Driver("Michael");
        Driver driver2 = new Driver("Zhu");

        Chef chef1 = new Chef("Sanji");
        Chef chef2 = new Chef("Mary");

        List<Worker> workers = new ArrayList<>();
        workers.add(programmer1);
        workers.add(programmer2);
        workers.add(driver1);
        workers.add(driver2);
        workers.add(chef1);
        workers.add(chef2);

        for (Worker worker : workers) {
            worker.about();
            if (worker instanceof Programmable) ((Programmable) worker).writeCode();
            if (worker instanceof Drivable) ((Drivable) worker).drive();
            if (worker instanceof Cookable) ((Chef) worker).cook();
        }
    }
}

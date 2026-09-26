import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

abstract class Employee {
    protected String name;
    protected double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {

    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends Employee {

    PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    double calculateBonus() {
        return salary * 0.05;
    }
}

class InternEmployee extends Employee {

    InternEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    double calculateBonus() {
        return 2000.0;
    }
}

public class Bonus {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Employee[] employees = new Employee[n];

        Map<String, Function<String[], Employee>> factory =
                new HashMap<>();

        factory.put("FULLTIME", data ->
                new FullTimeEmployee(
                        data[0],
                        Double.parseDouble(data[1])
                )
        );

        factory.put("PARTTIME", data ->
                new PartTimeEmployee(
                        data[0],
                        Double.parseDouble(data[1])
                )
        );

        factory.put("INTERN", data ->
                new InternEmployee(
                        data[0],
                        Double.parseDouble(data[1])
                )
        );

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            String[] data = {
                    name,
                    String.valueOf(salary)
            };

            employees[i] = factory.get(type).apply(data);
        }

        double totalBonus = 0.0;

        for (Employee employee : employees) {

            double bonus = employee.calculateBonus();

            totalBonus += bonus;

            System.out.printf(
                    "%s: %.2f%n",
                    employee.name,
                    bonus
            );
        }

        System.out.printf(
                "Total Bonus: %.2f%n",
                totalBonus
        );

        sc.close();
    }
}
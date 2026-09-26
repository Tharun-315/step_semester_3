import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

abstract class CustomerBill {

    protected double amount;

    CustomerBill(double amount) {
        this.amount = amount;
    }

    abstract double calculateFinalAmount();
}

class StudentBill extends CustomerBill {

    StudentBill(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount * 0.90;
    }
}

class StaffBill extends CustomerBill {

    StaffBill(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount * 0.95;
    }
}

class GuestBill extends CustomerBill {

    GuestBill(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount + 10;
    }
}

public class CanteenBilling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        CustomerBill[] bills = new CustomerBill[n];
        String[] types = new String[n];

        Map<String, Function<Double, CustomerBill>> factory =
                new HashMap<>();

        factory.put("STUDENT", StudentBill::new);
        factory.put("STAFF", StaffBill::new);
        factory.put("GUEST", GuestBill::new);

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            types[i] = type;

            bills[i] = factory.get(type).apply(amount);
        }

        double total = 0.0;

        for (int i = 0; i < n; i++) {

            double finalAmount = bills[i].calculateFinalAmount();

            total += finalAmount;

            System.out.printf(
                    "%s: %.2f%n",
                    types[i],
                    finalAmount
            );
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
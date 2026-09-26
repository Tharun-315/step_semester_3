import java.util.*;
import java.util.function.Function;

abstract class Delivery {
    protected double weight;
    protected double distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();
}

class StandardDelivery extends Delivery {

    StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    double calculateFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery extends Delivery {

    ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    double calculateFee() {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    double calculateFee() {
        return 25 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

public class FeeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Delivery[] deliveries = new Delivery[n];
        String[] types = new String[n];

        /*
         * Factory mapping:
         * This allows the main processing to work with
         * all delivery objects through the common Delivery type.
         */
        Map<String, Function<double[], Delivery>> factory = new HashMap<>();

        factory.put("STANDARD",
                values -> new StandardDelivery(values[0], values[1]));

        factory.put("EXPRESS",
                values -> new ExpressDelivery(values[0], values[1]));

        factory.put("INTERNATIONAL",
                values -> new InternationalDelivery(
                        values[0], values[1], values[2]));

        for (int i = 0; i < n; i++) {

            types[i] = sc.next();

            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            double customsFee = 0;

            if (types[i].equals("INTERNATIONAL")) {
                customsFee = sc.nextDouble();
            }

            double[] values = {
                    weight,
                    distance,
                    customsFee
            };

            deliveries[i] = factory.get(types[i]).apply(values);
        }

        double total = 0;

        for (int i = 0; i < n; i++) {

            double fee = deliveries[i].calculateFee();

            total += fee;

            System.out.printf(
                    "%s: %.2f%n",
                    types[i],
                    fee
            );
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
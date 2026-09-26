import java.util.Scanner;

abstract class TransportJourney {
    protected double distance;

    TransportJourney(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
}

class Bus extends TransportJourney {

    Bus(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        double fare = 2.0 + (0.10 * distance);

        // Maximum bus fare is $10
        return Math.min(fare, 10.0);
    }
}

class Train extends TransportJourney {

    Train(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
}

class Metro extends TransportJourney {

    private double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class Publictransport {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        TransportJourney[] journeys = new TransportJourney[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {

            types[i] = sc.next();

            double distance = sc.nextDouble();

            if (types[i].equals("BUS")) {

                journeys[i] = new Bus(distance);

            } else if (types[i].equals("TRAIN")) {

                journeys[i] = new Train(distance);

            } else if (types[i].equals("METRO")) {

                double peakHourFactor = sc.nextDouble();

                journeys[i] = new Metro(
                        distance,
                        peakHourFactor
                );
            }
        }

        double total = 0.0;

        for (int i = 0; i < n; i++) {

            double fare = journeys[i].calculateFare();

            total += fare;

            System.out.printf(
                    "%s: %.2f%n",
                    types[i],
                    fare
            );
        }

        System.out.printf(
                "Total: %.2f%n",
                total
        );

        sc.close();
    }
}
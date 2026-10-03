import java.util.Scanner;

abstract class Travel {
    int distance;

    Travel(int distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
}

class BusTravel extends Travel {

    BusTravel(int distance) {
        super(distance);
    }

    double calculateFare() {
        return 500 + distance * 2;
    }
}

class TrainTravel extends Travel {

    TrainTravel(int distance) {
        super(distance);
    }

    double calculateFare() {
        return 1000 + distance * 3;
    }
}

class FlightTravel extends Travel {

    FlightTravel(int distance) {
        super(distance);
    }

    double calculateFare() {
        return 2500 + distance * 4;
    }
}

public class traveling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String mode = sc.next();
            int distance = sc.nextInt();

            Travel t;

            if (mode.equals("BUS")) {
                t = new BusTravel(distance);
            }
            else if (mode.equals("TRAIN")) {
                t = new TrainTravel(distance);
            }
            else {
                t = new FlightTravel(distance);
            }

            System.out.printf("%s: %.2f%n",
                    mode, t.calculateFare());
        }

        sc.close();
    }
}
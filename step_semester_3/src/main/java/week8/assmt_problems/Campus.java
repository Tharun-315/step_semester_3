import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

abstract class ParkingVehicle {
    protected int hours;

    ParkingVehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculateCharge();
}

class ParkingBike extends ParkingVehicle {

    ParkingBike(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {
        return hours * 10.0;
    }
}

class ParkingCar extends ParkingVehicle {

    ParkingCar(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {
        return 30.0 + (hours - 1) * 20.0;
    }
}

class ParkingTruck extends ParkingVehicle {

    ParkingTruck(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {
        return Math.max(hours * 50.0, 100.0);
    }
}

public class Campus {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ParkingVehicle[] vehicles = new ParkingVehicle[n];
        String[] types = new String[n];

        Map<String, Function<Integer, ParkingVehicle>> factory =
                new HashMap<>();

        factory.put("BIKE", ParkingBike::new);
        factory.put("CAR", ParkingCar::new);
        factory.put("TRUCK", ParkingTruck::new);

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int hours = sc.nextInt();

            types[i] = type;

            vehicles[i] = factory.get(type).apply(hours);
        }

        double total = 0.0;

        for (int i = 0; i < n; i++) {

            double charge = vehicles[i].calculateCharge();

            total += charge;

            System.out.printf(
                    "%s: %.2f%n",
                    types[i],
                    charge
            );
        }

        System.out.printf(
                "Total: %.2f%n",
                total
        );

        sc.close();
    }
}
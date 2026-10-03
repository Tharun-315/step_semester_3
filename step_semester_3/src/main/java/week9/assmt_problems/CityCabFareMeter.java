import java.util.*;

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double rate();

    double baseFare() {
        return Math.max(km * rate(), 100);
    }
}

interface NightService {
    default double nightFare(double fare) {
        return fare * 1.20;
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double rate() {
        return 10;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double rate() {
        return 14;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double rate() {
        return 18;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Cab[] cabs = new Cab[n];
        String[] types = new String[n];
        String[] times = new String[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            types[i] = type;
            times[i] = time;

            if (type.equals("MINI"))
                cabs[i] = new Mini(km);
            else if (type.equals("SEDAN"))
                cabs[i] = new Sedan(km);
            else
                cabs[i] = new SUV(km);
        }

        double total = 0;

        for (int i = 0; i < n; i++) {
            if (times[i].equals("NIGHT") &&
                    !(cabs[i] instanceof NightService)) {

                System.out.println(types[i] + ": night service not available");
                continue;
            }

            double fare = cabs[i].baseFare();

            if (times[i].equals("NIGHT"))
                fare = ((NightService) cabs[i]).nightFare(fare);

            System.out.printf("%s: %.2f%n", types[i], fare);

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
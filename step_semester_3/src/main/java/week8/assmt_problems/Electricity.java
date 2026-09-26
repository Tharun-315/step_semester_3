import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

abstract class HostelRoom {
    protected int units;

    HostelRoom(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class HostelSingleRoom extends HostelRoom {

    HostelSingleRoom(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return units * 8.0;
    }
}

class HostelSharedRoom extends HostelRoom {

    private int occupants;

    HostelSharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class HostelACRoom extends HostelRoom {

    HostelACRoom(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return (units * 10.0) + 200.0;
    }
}

public class Electricity{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HostelRoom[] rooms = new HostelRoom[n];
        String[] types = new String[n];

        Map<String, Function<Scanner, HostelRoom>> factory =
                new HashMap<>();

        factory.put("SINGLE", scanner -> {
            int units = scanner.nextInt();
            return new HostelSingleRoom(units);
        });

        factory.put("SHARED", scanner -> {
            int units = scanner.nextInt();
            int occupants = scanner.nextInt();

            return new HostelSharedRoom(units, occupants);
        });

        factory.put("AC", scanner -> {
            int units = scanner.nextInt();
            return new HostelACRoom(units);
        });

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            types[i] = type;

            rooms[i] = factory.get(type).apply(sc);
        }

        double total = 0.0;

        for (int i = 0; i < n; i++) {

            double bill = rooms[i].calculateBill();

            total += bill;

            System.out.printf(
                    "%s: %.2f%n",
                    types[i],
                    bill
            );
        }

        System.out.printf(
                "Total: %.2f%n",
                total
        );

        sc.close();
    }
}
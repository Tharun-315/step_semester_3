import java.util.*;

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double power();

    double units() {
        return power() * hours / 1000;
    }

    double cost() {
        return units() * 8;
    }
}

interface SaverMode {
    default double saverUnits(double units) {
        return units * 0.75;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double power() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }

    double power() {
        return 1500;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double power() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }

    double power() {
        return 500;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Appliance[] appliances = new Appliance[n];
        String[] names = new String[n];
        boolean[] saver = new boolean[n];

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            double hours = sc.nextDouble();

            boolean isSaver = false;

            if (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.equals("SAVER"))
                    isSaver = true;
            }

            names[i] = name;
            saver[i] = isSaver;

            if (name.equals("FRIDGE"))
                appliances[i] = new Fridge(hours);
            else if (name.equals("AC"))
                appliances[i] = new AC(hours);
            else if (name.equals("TV"))
                appliances[i] = new TV(hours);
            else
                appliances[i] = new Washer(hours);
        }

        double totalCost = 0;

        for (int i = 0; i < n; i++) {

            if (saver[i] && !(appliances[i] instanceof SaverMode)) {
                System.out.println(names[i] + ": saver mode not supported");
                continue;
            }

            double units = appliances[i].units();

            if (saver[i])
                units = ((SaverMode) appliances[i]).saverUnits(units);

            double cost = units * 8;

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    names[i], units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}
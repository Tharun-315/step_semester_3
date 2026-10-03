import java.util.*;

abstract class Parcel {
    double weight;
    double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double shippingCharge();
}

interface Insurable {
    double insurance();
}

class Standard extends Parcel {
    Standard(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double shippingCharge() {
        return 40 + 10 * weight;
    }
}

class Express extends Parcel implements Insurable {
    Express(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double shippingCharge() {
        return 80 + 15 * weight;
    }

    public double insurance() {
        return declaredValue * 0.02;
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double shippingCharge() {
        return 40 + 10 * weight + 50;
    }

    public double insurance() {
        return declaredValue * 0.02;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Parcel[] parcels = new Parcel[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            types[i] = type;

            if (type.equals("STANDARD"))
                parcels[i] = new Standard(weight, value);
            else if (type.equals("EXPRESS"))
                parcels[i] = new Express(weight, value);
            else
                parcels[i] = new Fragile(weight, value);
        }

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            double charge = parcels[i].shippingCharge();
            double insurance = 0;

            if (parcels[i] instanceof Insurable)
                insurance = ((Insurable) parcels[i]).insurance();

            double total = charge + insurance;

            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    types[i], charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}
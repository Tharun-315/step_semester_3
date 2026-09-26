import java.util.Scanner;

abstract class PaymentMethod {
    protected double amount;

    PaymentMethod(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();
}

class Card extends PaymentMethod {

    Card(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount * 1.02;
    }
}

class Wallet extends PaymentMethod {

    Wallet(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount * 1.01;
    }
}

class BankTransfer extends PaymentMethod {

    BankTransfer(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount;
    }
}

public class Payment {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PaymentMethod[] payments = new PaymentMethod[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {

            types[i] = sc.next();
            double amount = sc.nextDouble();

            if (types[i].equals("CARD")) {
                payments[i] = new Card(amount);
            }
            else if (types[i].equals("WALLET")) {
                payments[i] = new Wallet(amount);
            }
            else if (types[i].equals("BANKTRANSFER")) {
                payments[i] = new BankTransfer(amount);
            }
        }

        double total = 0.0;

        for (int i = 0; i < n; i++) {

            double adjustedAmount = payments[i].calculateAmount();

            total += adjustedAmount;

            System.out.printf(
                    "%s: %.2f%n",
                    types[i],
                    adjustedAmount
            );
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
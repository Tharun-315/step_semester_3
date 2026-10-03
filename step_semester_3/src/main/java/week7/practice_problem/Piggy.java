class PiggyBank {
    private double savings;
    private final String id;

    // Constructor
    PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    // Deposit money
    void deposit(double amount) {
        savings += amount;
    }

    // Withdraw money
    void withdraw(double amount) {
        if (amount <= savings) {
            savings -= amount;
        } else {
            System.out.println("Withdrawal rejected");
        }
    }

    // Check savings
    double getSavings() {
        return savings;
    }

    // Check ID
    String getId() {
        return id;
    }
}

public class Piggy {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        System.out.println("Savings = " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("Savings = " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("Savings = " + pb.getSavings());
    }
}
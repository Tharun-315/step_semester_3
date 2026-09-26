class PiggyBank {
    private double savings;
    private final String id;

    // Constructor
    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            savings = savings + amount;
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > savings) {
            System.out.println("Withdrawal rejected");
        } else if (amount > 0) {
            savings = savings - amount;
        }
    }

    // Read-only access to savings
    public double getSavings() {
        return savings;
    }
}

public class cash {
    public static void main(String[] args) {

        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        System.out.println("Savings after deposit: " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("Savings after withdrawal: " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("Final savings: " + pb.getSavings());
    }
}
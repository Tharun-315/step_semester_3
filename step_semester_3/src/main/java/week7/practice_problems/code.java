class Locker {
    private String code;
    private final int lockerNumber;

    // Constructor
    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    // Change code only if current code is correct
    public boolean changeCode(String currentCode, String newCode) {
        if (code.equals(currentCode)) {
            code = newCode;
            return true;
        }

        return false;
    }
}

public class code {
    public static void main(String[] args) {

        Locker l = new Locker(101, "1234");

        // Correct current code
        if (l.changeCode("1234", "5678")) {
            System.out.println("Code changed successfully");
        } else {
            System.out.println("Code change rejected");
        }

        // Wrong current code
        if (l.changeCode("0000", "9999")) {
            System.out.println("Code changed successfully");
        } else {
            System.out.println("Code change rejected");
        }
    }
}
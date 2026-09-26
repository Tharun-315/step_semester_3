import java.util.Scanner;
class banktransaction {

    static String normalizeReference(String raw) {
        raw = raw.trim();

        if (raw.length() < 3) {
            return raw;
        }

        String bank = raw.substring(0, 3).toUpperCase();
        String rest = raw.substring(3);

        return bank + rest;
    }

    static String validateAndFormat(String reference) {

        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!java.lang.Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!java.lang.Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String bank = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String seq = reference.substring(9);

        String formattedDate = date.substring(0, 2) + "/" +
                date.substring(2, 4) + "/" +
                date.substring(4, 6);

        StringBuilder sb = new StringBuilder();

        sb.append("[");
        sb.append(bank);
        sb.append("] DATE: ");
        sb.append(formattedDate);
        sb.append(" | SEQ: ");
        sb.append(seq);

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter reference: ");
        String raw = sc.nextLine();

        String reference = normalizeReference(raw);

        System.out.println(validateAndFormat(reference));
    }
}
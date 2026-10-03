class AttendanceSheet {
    private String[] students;
    private int count;

    // Constructor
    AttendanceSheet(int size) {
        students = new String[size];
        count = 0;
    }

    // Mark student present
    void markPresent(String name) {
        if (!isPresent(name) && count < students.length) {
            students[count] = name;
            count++;
        }
    }

    // Get number of present students
    int getPresentCount() {
        return count;
    }

    // Check whether student is present
    boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}

public class Attandance {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present Count = " + sheet.getPresentCount());
        System.out.println("Ben present = " + sheet.isPresent("Ben"));
        System.out.println("Chen present = " + sheet.isPresent("Chen"));
    }
}
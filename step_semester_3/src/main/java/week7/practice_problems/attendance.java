class AttendanceSheet {
    private String[] students;
    private int presentCount;

    // Constructor
    public AttendanceSheet(int maximumStudents) {
        students = new String[maximumStudents];
        presentCount = 0;
    }

    // Mark a student present
    public void markPresent(String name) {

        // Check if student is already present
        if (isPresent(name)) {
            return;
        }

        // Add student if there is space
        if (presentCount < students.length) {
            students[presentCount] = name;
            presentCount++;
        }
    }

    // Return number of present students
    public int getPresentCount() {
        return presentCount;
    }

    // Check whether a student is present
    public boolean isPresent(String name) {
        for (int i = 0; i < presentCount; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }
}

public class attendance {
    public static void main(String[] args) {

        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());

        System.out.println("Ben present: " + sheet.isPresent("Ben"));

        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}
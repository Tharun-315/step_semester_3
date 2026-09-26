class Course {
    String code;
    String title;
    int credits;
    int labCredits;

    // Four-argument constructor
    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    // Three-argument constructor
    // Calls the four-argument constructor using this()
    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    // Method to calculate total credits
    public int totalCredits() {
        return credits + labCredits;
    }
}

public class credit {
    public static void main(String[] args) {

        // Course using three-argument constructor
        Course course1 = new Course(
                "21CSC201J",
                "Data Structures",
                4
        );

        // Course using four-argument constructor
        Course course2 = new Course(
                "21CSC205L",
                "DSA Lab",
                3,
                1
        );

        // Print total credits
        System.out.println(course1.code + " total credits: " + course1.totalCredits());
        System.out.println(course2.code + " total credits: " + course2.totalCredits());
    }
}
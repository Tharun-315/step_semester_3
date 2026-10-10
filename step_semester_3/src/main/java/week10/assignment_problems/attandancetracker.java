package week10.assignment_problems;


public class attandancetracker {

    public static void attendanceSummary(int[] days) {
        int present = 0;
        int streak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                present++;
                streak++;

                if (streak > longestStreak) {
                    longestStreak = streak;
                }
            } else {
                streak = 0;
            }
        }

        System.out.println("Present: " + present
                + ", Longest streak: " + longestStreak);
    }

    public static void main(String[] args) {
        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};
        int[] days2 = {0, 0, 0};

        attendanceSummary(days1);
        attendanceSummary(days2);
    }
}

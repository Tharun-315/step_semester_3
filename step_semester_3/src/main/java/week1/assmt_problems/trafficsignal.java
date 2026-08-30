public class trafficsignal {

    static void findLongestStreak(String signalLog) {
        int max = 1;
        int current = 1;
        char color = signalLog.charAt(0);

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                current++;
            } else {
                current = 1;
            }

            if (current > max) {
                max = current;
                color = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + color +
                "' repeated " + max + " times");
    }

    public static void main(String[] args) {
        String signalLog = "RRGGGYRR";

        findLongestStreak(signalLog);
    }
}
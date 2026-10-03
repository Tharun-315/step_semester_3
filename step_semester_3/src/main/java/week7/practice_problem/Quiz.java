class Scorecard {
    private boolean[] results;
    private int count;
    private int score;

    // Constructor
    Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        count = 0;
        score = 0;
    }

    // Record next answer
    void recordAnswer(boolean correct) {
        if (count < results.length) {
            results[count] = correct;

            if (correct) {
                score++;
            }

            count++;
        } else {
            System.out.println("No more answers can be recorded.");
        }
    }

    // Return only the score
    int getScore() {
        return score;
    }
}

public class Quiz {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score = " + sc.getScore());
    }
}
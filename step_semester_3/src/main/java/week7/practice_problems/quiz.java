class Scorecard {
    private boolean[] results;
    private int answerCount;

    // Constructor
    public Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        answerCount = 0;
    }

    // Record the next answer
    public void recordAnswer(boolean correct) {
        if (answerCount < results.length) {
            results[answerCount] = correct;
            answerCount++;
        }
    }

    // Return total score
    public int getScore() {
        int score = 0;

        for (int i = 0; i < answerCount; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }
}

public class quiz {
    public static void main(String[] args) {

        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}
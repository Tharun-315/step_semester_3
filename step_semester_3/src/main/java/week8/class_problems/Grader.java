import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class ExamQuestion {

    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    ExamQuestion(
            String questionText,
            String correctAnswer,
            String studentAnswer,
            double points) {

        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double evaluate();
}

class MCQQuestion extends ExamQuestion {

    MCQQuestion(
            String questionText,
            String correctAnswer,
            String studentAnswer,
            double points) {

        super(
                questionText,
                correctAnswer,
                studentAnswer,
                points
        );
    }

    @Override
    double evaluate() {

        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class TFQuestion extends ExamQuestion {

    TFQuestion(
            String questionText,
            String correctAnswer,
            String studentAnswer,
            double points) {

        super(
                questionText,
                correctAnswer,
                studentAnswer,
                points
        );
    }

    @Override
    double evaluate() {

        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class EssayQuestion extends ExamQuestion {

    EssayQuestion(
            String questionText,
            String correctAnswer,
            String studentAnswer,
            double points) {

        super(
                questionText,
                correctAnswer,
                studentAnswer,
                points
        );
    }

    @Override
    double evaluate() {

        String[] keywords = correctAnswer.split(",");

        int matchedKeywords = 0;

        String answer = studentAnswer.toLowerCase();

        for (String keyword : keywords) {

            keyword = keyword.trim().toLowerCase();

            if (answer.contains(keyword)) {
                matchedKeywords++;
            }
        }

        if (matchedKeywords >= 2) {
            return points * 0.75;
        }
        else if (matchedKeywords == 1) {
            return points * 0.50;
        }
        else {
            return 0;
        }
    }
}

public class Grader{

    /*
     * Reads:
     * MCQ "question" "correct answer" "student answer" 10
     *
     * and separates the quoted strings correctly.
     */
    private static List<String> parseLine(String line) {

        List<String> tokens = new ArrayList<>();

        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");

        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {

            if (matcher.group(1) != null) {
                tokens.add(matcher.group(1));
            }
            else {
                tokens.add(matcher.group(2));
            }
        }

        return tokens;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        ExamQuestion[] questions = new ExamQuestion[n];

        String[] types = new String[n];

        /*
         * Factory mapping for polymorphic question creation.
         */
        Map<String, Function<String[], ExamQuestion>> factory
                = new HashMap<>();

        factory.put(
                "MCQ",
                data -> new MCQQuestion(
                        data[0],
                        data[1],
                        data[2],
                        Double.parseDouble(data[3])
                )
        );

        factory.put(
                "TF",
                data -> new TFQuestion(
                        data[0],
                        data[1],
                        data[2],
                        Double.parseDouble(data[3])
                )
        );

        factory.put(
                "ESSAY",
                data -> new EssayQuestion(
                        data[0],
                        data[1],
                        data[2],
                        Double.parseDouble(data[3])
                )
        );

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            List<String> tokens = parseLine(line);

            types[i] = tokens.get(0);

            String[] data = {
                    tokens.get(1),
                    tokens.get(2),
                    tokens.get(3),
                    tokens.get(4)
            };

            questions[i] = factory.get(types[i]).apply(data);
        }

        double totalScore = 0;

        for (int i = 0; i < n; i++) {

            double score = questions[i].evaluate();

            totalScore += score;

            System.out.printf(
                    "%s: %.2f%n",
                    types[i],
                    score
            );
        }

        System.out.printf(
                "Total Score: %.2f%n",
                totalScore
        );

        sc.close();
    }
}
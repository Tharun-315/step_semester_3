import java.util.Arrays;

public class top3scores {

    static int[] findTop3(int[] scores) {

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {

            if (score > first) {
                third = second;
                second = first;
                first = score;
            }
            else if (score > second) {
                third = second;
                second = score;
            }
            else if (score > third) {
                third = score;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {

        int[] scores = {70, 95, 85, 60, 90};

        int[] result = findTop3(scores);

        System.out.println(Arrays.toString(result));
    }
}
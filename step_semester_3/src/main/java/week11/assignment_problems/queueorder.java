package week11.assignment_problems;

public class queueorder {

    static int firstBreak(int[] tokens) {

        for (int i = 1; i < tokens.length; i++) {

            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] tokens = {3, 5, 5, 8, 6, 9};

        System.out.println(firstBreak(tokens));

        // Second sample input
        int[] tokens2 = {1, 2, 2, 7};

        System.out.println(firstBreak(tokens2));

        // Own test input
        int[] tokens3 = {2, 4, 7, 5, 9};

        System.out.println(firstBreak(tokens3));
    }
}


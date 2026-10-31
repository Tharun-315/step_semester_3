package week11.assignment_problems;

import java.util.Arrays;

public class dicethrow {

    static int[] diceSort(int[] rolls) {

        int[] count = new int[7];

        // Step 1: Count each number
        for (int i = 0; i < rolls.length; i++) {
            count[rolls[i]]++;
        }

        // Step 2: Print counts
        System.out.print("Counts: ");

        for (int i = 1; i <= 6; i++) {
            System.out.print(i + ":" + count[i] + " ");
        }

        System.out.println();

        // Step 3: Build sorted array
        int[] sorted = new int[rolls.length];

        int index = 0;

        for (int i = 1; i <= 6; i++) {

            for (int j = 0; j < count[i]; j++) {
                sorted[index] = i;
                index++;
            }
        }

        return sorted;
    }

    public static void main(String[] args) {

        int[] rolls = {4, 1, 6, 4, 2, 1, 4};

        int[] result = diceSort(rolls);

        System.out.println("Sorted: " + Arrays.toString(result));

        // Own test input
        int[] rolls2 = {6, 3, 2, 3, 1, 6};

        int[] result2 = diceSort(rolls2);

        System.out.println("Sorted: " + Arrays.toString(result2));
    }
}

package week11.assignment_problems;

import java.util.Arrays;
public class pricetable {

    static int prizeTable(int[] marks) {

        int swaps = 0;

        for (int i = 0; i < marks.length - 1; i++) {

            int maxIndex = i;

            // Find the largest mark
            for (int j = i + 1; j < marks.length; j++) {

                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Swap only if needed
            if (maxIndex != i) {

                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;

                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {

        int[] marks = {45, 90, 60, 75};

        int swaps = prizeTable(marks);

        System.out.println(Arrays.toString(marks));
        System.out.println("Swaps = " + swaps);

        // Own test input
        int[] marks2 = {80, 70, 60};

        int swaps2 = prizeTable(marks2);

        System.out.println(Arrays.toString(marks2));
        System.out.println("Swaps = " + swaps2);
    }
}

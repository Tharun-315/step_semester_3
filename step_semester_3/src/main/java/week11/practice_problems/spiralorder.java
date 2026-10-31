package week11.practice_problems;

import java.util.ArrayList;

public class spiralorder {

    static ArrayList<Integer> spiralOrder(int[][] grid) {

        ArrayList<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = grid.length - 1;

        int left = 0;
        int right = grid[0].length - 1;

        while (top <= bottom && left <= right) {

            // Left to right
            for (int i = left; i <= right; i++) {
                result.add(grid[top][i]);
            }
            top++;

            // Top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(grid[i][right]);
            }
            right--;

            // Right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(grid[bottom][i]);
                }
                bottom--;
            }

            // Bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(grid[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(spiralOrder(grid));

        // Own test
        int[][] grid2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };

        System.out.println(spiralOrder(grid2));
    }
}

import java.util.*;

class threesum {
    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};

        Arrays.sort(a);

        for (int i = 0; i < a.length - 2; i++) {
            int left = i + 1;
            int right = a.length - 1;

            while (left < right) {
                int sum = a[i] + a[left] + a[right];

                if (sum == 0) {
                    System.out.println(a[i] + " " + a[left] + " " + a[right]);
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }
}
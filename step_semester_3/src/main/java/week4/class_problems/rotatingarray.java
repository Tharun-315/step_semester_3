public class rotatingarray {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;

        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }

        System.out.println("Rotated Array:");

        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
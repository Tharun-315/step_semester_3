package week11.practice_problems;

public class pairsum {

    static String pairSumSorted(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int sum = nums[left] + nums[right];

            if (sum == target) {

                return "(" + nums[left] + ", "
                        + nums[right] + ")";
            }

            else if (sum < target) {
                left++;
            }

            else {
                right--;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {

        int[] nums1 = {-4, -1, 0, 3, 5, 9};

        System.out.println(pairSumSorted(nums1, 4));

        int[] nums2 = {1, 2, 3};

        System.out.println(pairSumSorted(nums2, 100));

        // Own test
        int[] nums3 = {1, 3, 5, 7};

        System.out.println(pairSumSorted(nums3, 8));
    }
}


package week11.practice_problems;

import java.util.HashSet;

public class pairwithtarget{

    static boolean hasPairWithSum(int[] nums, int target) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            int needed = target - nums[i];

            if (set.contains(needed)) {
                return true;
            }

            set.add(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 7, 11, 15};

        System.out.println(hasPairWithSum(nums1, 9));

        int[] nums2 = {3, 4, 6};

        System.out.println(hasPairWithSum(nums2, 20));

        // Own test input
        int[] nums3 = {5, 5, 2, 8};

        System.out.println(hasPairWithSum(nums3, 10));
    }
}

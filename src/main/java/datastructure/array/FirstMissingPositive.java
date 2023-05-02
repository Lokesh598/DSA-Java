package datastructure.array;

/**
 * 41. leetcode problem.
 * we need to find first positive missing number in the given array
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean one = false;
        for(int i = 0; i < n; i++) {
            if (nums[i] == 1)
                one = true;

            if (nums[i] < 1 || n < nums[i])
                nums[i] = 1;
        }
        if (!one) return 1;

        for (int i = 0; i < n; i++) {
            int indx = Math.abs(nums[i]);

            nums[indx - 1] = -Math.abs(nums[indx-1]);
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i+1;
        }
        return n+1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,6,3,5,4};
        System.out.println(firstMissingPositive(arr));
    }
}

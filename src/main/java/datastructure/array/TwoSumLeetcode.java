package datastructure.array;

import java.util.Arrays;

/**
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 */
public class TwoSumLeetcode {
    public static int[] twoSum(int[] arr, int target) {
        int[] res = new int[arr.length];
        int left = 0, right = arr.length-1;
        Arrays.sort(arr);

        while (left < right) {
            if (left != 0 && arr[left] == arr[left-1]) {
                left++;
                continue;
            }
            int sum = arr[left] + arr[right];
            if (sum == target) {
                res[left] = left;
                res[right] = right;
                left++;
                right --;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3,2,4};
        System.out.println(Arrays.toString(twoSum(arr, 6)));
    }
}

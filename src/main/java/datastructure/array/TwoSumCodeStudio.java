package datastructure.array;

import java.util.*;

/**
 * Input: nums = [3,2,4], target = 6
 * Output: [2,4]
 */
public class TwoSumCodeStudio {
    public static List<Integer> twoSum(int[] arr, int target) {
//        Integer[] res;
        List<Integer> res = new ArrayList<>();
        int left = 0, right = arr.length-1;
        Arrays.sort(arr);

        while (left < right) {
            if (left != 0 && arr[left] == arr[left-1]) {
                left++;
                continue;
            }
            int sum = arr[left] + arr[right];
            if (sum == target) {
                res.add(arr[left]);
                res.add(arr[right]);
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
        int[] arr = new int[] {2,1,1,2,4,3,6,5,6,8,7,9,9};
        System.out.println(twoSum(arr, 10));
    }
}

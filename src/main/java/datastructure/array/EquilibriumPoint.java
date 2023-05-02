package datastructure.array;

public class EquilibriumPoint {
    static int equilibriumPoint(long arr[], int n) {
        // Your code here
        int left = 0, right = n-1;
        int a = 0, b = 0;
        if (n == 1) return 1;
        while(left < right) {

            if(a < b) {
                a += arr[left];
                left++;
            } else {
                b += arr[right];
                right--;
            }

            if(a == b && left == right)
                return left + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        long[] arr = new long[] {1, 3, 5, 2, 2};
        System.out.println(equilibriumPoint(arr, 5));
    }
}

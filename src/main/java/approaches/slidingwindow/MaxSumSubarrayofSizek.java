package approaches.slidingwindow;

import java.util.ArrayList;
import java.util.Scanner;

class MaxSumSubarrayofSizek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList(N);

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            arrayList.add(x);
        }
        Solution ob = new Solution();
        System.out.println(ob.maximumSumSubarray(K, arrayList, N));
    }
}
class Solution{
    long maximumSumSubarray(int K, ArrayList<Integer> arr, int N){
        // code here
        long sum = 0;
        long tmpSum = 0;
        for (int i = 0; i<=N-K; i++) {
            for (int j = i; j<i+K; j++) {
                tmpSum += arr.get(j);
            }
            sum = Math.max(sum, tmpSum);
            tmpSum = 0;
        }
        return sum;
    }
}

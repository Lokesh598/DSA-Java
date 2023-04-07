package dynamicprogramming.unboundedknapsack;

/**
 * @Problem
 * Given an integer array coins[ ] of size N representing different denominations of currency and
 * an integer sum, find the number of ways you can make sum by using different
 * combinations from coins[ ].
 * Note: Assume that you have an infinite supply of each type of coin
 */

/**
 * @example
 * Input:
 * sum = 4 ,
 * N = 3
 * coins[] = {1,2,3}
 * Output: 4
 * Explanation: Four Possible ways are:
 * {1,1,1,1},{1,1,2},{2,2},{1,3}.
 */
public class CoinChange {

    public static long count(int coins[], int n, int sum) {
        // code here.

        long[][] dp = new long[n+1][sum+1];
        for (int i = 0; i<n+1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j<sum+1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i<dp.length; i++) {
            for (int j = 1; j<dp[0].length; j++) {
                if (coins[i-1] <= j) {
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }
    public static void main(String[] args) {

        int n = 4;
        int[] coins = new int[]{2, 5, 3, 6};
        int sum = 10;
//        for (int i: coins) {
//            sum += i;
//        }
        long res = count(coins, n, sum);
        System.out.println(res);
    }
}

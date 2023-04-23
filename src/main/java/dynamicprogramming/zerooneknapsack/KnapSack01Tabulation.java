package dynamicprogramming.zerooneknapsack;

public class KnapSack01Tabulation {
    static int knapSack(int w, int wt[], int val[], int n)
    {
        int[][] dp = new int[n+1][w+1];
        for(int i = 0; i<=n; i++) {
            dp[i][0] = 0;
        }
        for(int i = 0; i<=w; i++) {
            dp[0][i] = 0;
        }
        for(int i = 1; i<=n; i++) {
            for(int j = 1; j <= w; j++) {
                if(wt[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                }
            }
        }
        return dp[n][w];
    }
    public static void main(String[] args) {
        int W = 4;
        int n = 3;
        int[] val = new int[]{1,2,3};
        int[] wt = new int[]{4,5,6};
        System.out.println(knapSack(4, val, wt, 3));
    }
}

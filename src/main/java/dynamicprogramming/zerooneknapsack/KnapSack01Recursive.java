package dynamicprogramming.zerooneknapsack;

/**
 * recursive solution for 01 knapsack
 */
public class KnapSack01Recursive {
    static int knapSack(int w, int wts[], int val[], int n)
    {
        // your code here
        if(n == 0 || w == 0)
            return 0;
        if(wts[n-1] > w) {
            return knapSack(w, wts, val, n-1);
        } else {
            return Math.max(knapSack(w, wts, val, n-1), val[n-1] + knapSack(w-wts[n-1], wts, val, n-1));
        }
    }
    public static void main(String[] args) {

    }
}

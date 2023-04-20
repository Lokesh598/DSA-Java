package dynamicprogramming.dponstocks.leetcode;

/**
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] arr) {
        int min = arr[0];
        int profit = 0;

        for(int i = 1; i < arr.length; i++) {
            int cost = arr[i] - min;

            profit = Math.max(profit, cost);
            min = Math.min(min, arr[i]);
        }
        return profit;
    }
}

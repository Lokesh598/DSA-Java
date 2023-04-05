package dynamicprogramming;

import java.util.Scanner;

public class SubsetSumProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = 5;
        int[] arr = new int[n];
        for(int i = 0; i<n; i++ ){
            arr[i] = sc.nextInt();
        }

        int sum = sc.nextInt();

        boolean[][] t = new boolean[n+1][sum+1];

        for(int i = 1; i<t.length; i++) {
            for(int j = 1; j<t[0].length; j++) {

                t[i][0] = true;
                t[0][0] = true;
                t[0][j] = false;
                if(arr[i-1] <= j) {
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                } else
                    t[i][j] = t[i-1][j];
            }
        }
        System.out.println(t[n][sum]);
    }
}

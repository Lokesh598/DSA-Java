package algorithm.sorting;

import java.util.Scanner;

/**
 * Quick Sort Algorithm
 */
public class QuickSort {

    static void printArray(int[] arr) {
        for (int i: arr) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T>0) {

            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            Solution.quickSort(arr, 0, n-1);
            printArray(arr);
            T--;
        }
    }
}
class Solution {
    static void quickSort(int arr[], int lo, int hi) {
        if (lo < hi) {
            int m = partition(arr, lo, hi);
            quickSort(arr, lo, m-1);
            quickSort(arr, m+1, hi);
        }
    }

    static int partition(int arr[], int p, int q) {

        int i = p;
        int pivot = arr[p];
        for (int j = p+1; j<=q; j++) {
            if (arr[j]< pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[i];
        arr[i] = arr[p];
        arr[p] = tmp;
        return i;
    }
}
package algorithm.sorting.MergeSort;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[6];
        arr[0] = 9;
        arr[1] = 1;
        arr[2] = 3;
        arr[3] = 2;
        arr[4] = 0;
//        arr[5] = 5;
        Solution.mergeSort(arr, 0, 5);

        for (int i: arr) {
            System.out.println(i);
        }
    }
}
class Solution {
    static void mergeSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            mergeSort(arr, lo, mid);
            mergeSort(arr, mid+1, hi);
            merge(arr, lo, mid, hi);
        }
    }
    private static void merge(int[] arr, int l, int mid, int r) {
        int m = mid-l+1;
        int n = r-mid;
        int[] A = new int[m];
        int[] B = new int[n];
        // int *A = new int[m];
        // int *B = new int[n];
        for(int i = 0; i<m; i++) {
            A[i] = arr[i+l];
        }
        for(int j = 0; j<n; j++) {
            B[j] = arr[mid+1+j];
        }
        int i = 0, j = 0, k = l;
        while(i<m && j<n) {
            if(A[i] <= B[j]) {
                arr[k++] = A[i++];
            }
            else
                arr[k++] = B[j++];
        }
        while(i<m) {
            arr[k++] = A[i++];
        }
        while(j<n) {
            arr[k++] = B[j++];
        }
    }

}

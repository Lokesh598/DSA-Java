package datastructure.array;

import java.util.Arrays;

public class RotateArray {
    static void reverseArr(int[] arr, int start, int end) {
        while (start<end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
    static void rotateArr(int arr[], int d, int n)
    {
        //for large d
        d=d%n;
        reverseArr(arr, 0, d-1);
        reverseArr(arr, d, n-1);
        reverseArr(arr, 0, n-1);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        int d = 2;
        rotateArr(arr, d, 5);
        for (int i = 0; i < 5; i++) {
            System.out.print(arr[i]);
        }
    }
}

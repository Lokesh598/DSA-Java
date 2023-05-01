package datastructure.array;

public class SecondLargestElement {
    static int firstLargest(int[] arr, int n) {
        int first = arr[0];
        for(int i = 1; i < n; i++) {
            if(first < arr[i])
                first = arr[i];
        }
        return first;
    }
    static int print2largest(int arr[], int n) {
        // code here
        int first = firstLargest(arr, n);
        int second = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] != first) {
                if (second < arr[i]) {
                    second = arr[i];
                }
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 2, 0};
        System.out.println(print2largest(arr, 4));
    }
}

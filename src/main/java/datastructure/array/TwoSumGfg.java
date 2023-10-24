package datastructure.array;


import java.util.ArrayList;
import java.util.Arrays;

class pair {
    long first, second;
    public pair(long first, long second)
    {
        this.first = first;
        this.second = second;
    }
}
public class TwoSumGfg {
    public static pair[] allPairs( long A[], long B[], long N, long M, long x) {
        // Your code goes here
        pair[] res;
        int a = 0;
        int b = B.length-1;
        Arrays.sort(A);
        Arrays.sort(B);

        ArrayList<pair> pairs = new ArrayList<>();

        while (a < b) {
            if (a != 0 && A[a] == A[a-1]) {
                a++;
                continue;
            }
            long sum = A[a] + B[b];
            if (sum == x) {
                pairs.add(new pair(a, b));
                a++; b--;
            } else if (sum > x) {
                b--;
            } else {
                a++;
            }
        }
        res = new pair[pairs.size()];
        return pairs.toArray(res);
    }

    public static void main(String[] args) {
        long[] arr = new long[] {1, 2, 4, 5, 7};
        long[] b = new long[] {5, 6, 3, 4, 8};

        System.out.println( allPairs(arr, b, 5, 5, 9));
    }
}

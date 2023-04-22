package datastructure.stack.MaximumAreaOfHistogram;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


/**
 * 1. using stack span problem we will calculate NSL and NSR index arrays.
 * 2. then we will find widht array using Indexnsr[i] - Indexnsl[i] = width[i];
 * 3. then we will find res[i] = hist[i]-width[i];
 * 4. find max element from res array and return that element;
 *
 * Input:
 * N = 7
 * arr[] = {6,2,5,4,5,1,6}
 * Output: 12
 */

class Pair {
    long key;
    long value;
    public Pair(long key,long value){
        this.key = key;
        this.value = value;
    }
}
public class MaximumRectangularAreaInAHistogram {
//nsl
    public static long[] calculateNSLIndex(long[] arr, int n) {
        long[] res = new long[n];
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (st.empty()) {
                res[i] = -1;
                st.add(new Pair(i, arr[i]));
            } else if (st.size() > 0 && st.peek().value < arr[i]) {
                res[i] = st.peek().key;
                st.add(new Pair(i, arr[i]));
            } else if (st.size() > 0 && st.peek().value >= arr[i]) {
                while (st.size() > 0 && st.peek().value >= arr[i]) {
                    st.pop();
                }
                if (st.size() == 0) {
                    res[i] = -1;
                } else {
                    res[i] = st.peek().key;
                }
                st.add(new Pair(i, arr[i]));
            }
        }
        return res;
    }
    public static long[] calculateNSRIndex(long[] arr, int n) {
        long[] resOfNSR = new long[n];
        Stack<Pair> s = new Stack<>();

        for (int i = n-1; i >= 0; i--) {
            if (s.empty()) {
                resOfNSR[i] = n;
                s.add(new Pair(i, arr[i]));
            } else if (s.size() > 0 && s.peek().value < arr[i]) {
                resOfNSR[i] = s.peek().key;
                s.add(new Pair(i, arr[i]));
            } else if (s.size() > 0 && s.peek().value >= arr[i]) {
                while (s.size() > 0 && s.peek().value >= arr[i]) {
                    s.pop();
                }
                if (s.size() == 0) {
                    resOfNSR[i] = n;
                } else {
                    resOfNSR[i] = s.peek().key;
                }
                s.add(new Pair(i, arr[i]));
            }
        }
        return resOfNSR;
    }

    public static long getMaxArea(long[] hist, long n)
    {
        // your code here
        long max = Integer.MIN_VALUE;

        if(hist.length == 1)
            return hist[0];

        if(hist.length == 2) {
//            return hist[0]>hist[1]?hist[0]:hist[1];
            return Math.max(hist[0], hist[1]);
        }


        long[] nslIndex = calculateNSLIndex(hist, hist.length);
        long[] nsrIndex = calculateNSRIndex(hist, hist.length);
        long[] width = new long[nsrIndex.length];
        long[] res = new long[hist.length];
        for (int i = 0; i < nsrIndex.length; i++) {
            width[i] = nsrIndex[i]-nslIndex[i]-1;
        }
        for (int i = 0; i< hist.length; i++) {
            res[i] = hist[i]*width[i];
        }
        System.out.println("left"+Arrays.toString(nslIndex));
        System.out.println("right"+Arrays.toString(nsrIndex));
        System.out.println("width"+Arrays.toString(width));
        System.out.println("hist[] - width[]"+Arrays.toString(res));
        for (int i = 1; i < res.length; i++) {

            if(res[i] >= res[i-1]){
                max = Math.max(max, res[i]);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        long[] arr = new long[]{6,2,5,4,5,1,6};
//        long[] arr = new long[]{18, 2};
        System.out.println(getMaxArea(arr, arr.length));
    }
}

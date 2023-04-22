package datastructure.stack.MaximumAreaOfRectangleInABinaryMatrix;

import java.util.Arrays;
import java.util.Stack;


/**
 * this question is similar to MAH but need to do little modification.
 * vry straight forward solution
 */
class Pair {
    int key;
    int value;
    public Pair(int key, int value){
        this.key = key;
        this.value = value;
    }
}
public class MaximumAreaOfRectangleInABinaryMatrix {
    //calculate MAH
    public static int[] calculateNSLIndex(int[] arr, int n) {
        int[] res = new int[n];
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
    public static void reverse(int[] resOfNSR) {
        int lo = 0;
        int hi = resOfNSR.length-1;
        while(lo<hi) {
            int temp = lo;
            lo = hi;
            hi = temp;
            lo++;
            hi--;
        }
    }
    public static int[] calculateNSRIndex(int[] arr, int n) {
        int[] resOfNSR = new int[n];
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
//        reverse(resOfNSR);
        return resOfNSR;
    }

    public static int calculateMAH(int[] hist)
    {
        // your code here
//        int max = Integer.MIN_VALUE;

        if(hist.length == 1)
            return hist[0];

        if(hist.length == 2) {
            return Math.max(hist[0], hist[1]);
        }


        int[] nslIndex = calculateNSLIndex(hist, hist.length);
        int[] nsrIndex = calculateNSRIndex(hist, hist.length);
        int[] width = new int[nsrIndex.length];
        int[] area = new int[hist.length];
        for (int i = 0; i < nsrIndex.length; i++) {
            width[i] = nsrIndex[i]-nslIndex[i]-1;
        }
        for (int i = 0; i< hist.length; i++) {
            area[i] = hist[i]*width[i];
        }
//        for (int i = 1; i < area.length; i++) {
//            if(area[i] >= area[i-1]){
//                max = Math.max(max, area[i]);
//            }
//        }
        int max = area[0];
        for (int i = 1; i < area.length; i++) {

            if(area[i] >= max){
                max = area[i];
            }
        }
        return max;
    }

    public static int maxArea(int[][] arr, int n, int m) {
        // add code here.
        int[] vector = new int[1000];
        int maxArea=0;
        for (int j = 0; j < m; j++) {
            vector[j] = arr[0][j];
        }
        maxArea = calculateMAH(vector);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    vector[j] = 0;
                } else {
                    vector[j] = vector[j] + arr[i][j];
                }
            }
            maxArea = Math.max(maxArea, calculateMAH(vector));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}};
//        int[][] matrix = new int[][]{{1, 1, 1, 1, 1},
//                {0, 1, 0, 0, 0}};
        System.out.println(maxArea(matrix, 4, 4));
    }
}

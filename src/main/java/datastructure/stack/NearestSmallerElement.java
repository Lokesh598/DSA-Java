package datastructure.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


/**
 * Smallest number on left
 * Input: n = 6
 * a = {1, 5, 0, 3, 4, 5}
 * Output: -1 1 -1 0 3 4
 * Explaination: Upto 3 it is easy to see
 * the smaller numbers. But for 4 the smaller
 * numbers are 1, 0 and 3. But among them 3
 * is closest. Similary for 5 it is 4.
 */
public class NearestSmallerElement {
    static List<Integer> leftSmaller(int n, int arr[])
    {
        //code here
        // long[] res = new long[n];
        List<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if(st.empty()) {
//                res1[i] = -1;
                res.add(i, -1);
                st.push(arr[i]);
            } else if (st.size() > 0 && st.peek() < arr[i]) {
//                res[i] = st.peek();
                res.add(i, st.peek());
                st.push(arr[i]);
            } else if (st.size() > 0 && st.peek() >= arr[i]) {
                while(st.size() > 0 && st.peek() >= arr[i]) {
                    st.pop();
                }
                if (st.size() == 0) {
//                    res[i] = -1;
                    res.add(i, -1);
                } else {
//                    res[i] = st.peek();
                    res.add(i, st.peek());
                }
                st.push(arr[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 0, 3, 4, 5};
        System.out.println(leftSmaller( arr.length, arr));
    }
}

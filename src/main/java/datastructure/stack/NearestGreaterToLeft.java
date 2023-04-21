package datastructure.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NearestGreaterToLeft {
    public static long[] nextLargerElement(long[] arr, int n) {
        long[] res = new long[n];
        Stack<Long> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(st.empty()) {
                res[i] = -1;
                st.push(arr[i]);
            } else if (st.size() > 0 && st.peek() > arr[i]) {
                res[i] = st.peek();
                st.push(arr[i]);
            } else if (st.size() > 0 && st.peek() <= arr[i]) {
                while(st.size() > 0 && st.peek() <= arr[i]) {
                    st.pop();
                }
                if (st.size() == 0) {
                    res[i] = -1;
                } else {
                    res[i] = st.peek();
                }
                st.push(arr[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        long[] arr = new long[]{1, 3, 2, 4};
        System.out.println(Arrays.toString(nextLargerElement(arr, arr.length)));
    }
}

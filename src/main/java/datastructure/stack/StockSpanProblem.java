package datastructure.stack;

import java.util.Arrays;
import java.util.Stack;


/**
 * this problem use the concept of Nearest greater to left
 *
 * Input:
 * N = 7, price[] = [100 80 60 70 60 75 85]
 * Output:
 * 1 1 1 2 1 4 6
 *
 * 1. find index array of Nearest greater to left then find new array using substract
 * its index to its value
 */
class Pair {
    int key;
    int value;
    public Pair(int key,int value){
        this.key = key;
        this.value = value;
    }
}
public class StockSpanProblem {
    public static int[] calculateSpan(int[] arr, int n)
    {
        int[] res = new int[n];
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(st.empty()) {
                res[i] = -1;
                st.add(new Pair(i,arr[i]));
            } else if (st.size() > 0 && st.peek().value > arr[i]) {
                res[i] = st.peek().key;
                st.add(new Pair(i,arr[i]));
            } else if (st.size() > 0 && st.peek().value <= arr[i]) {
                while(st.size() > 0 && st.peek().value <= arr[i]) {
                    st.pop();
                }
                if (st.size() == 0) {
                    res[i] = -1;
                } else {
                    res[i] = st.peek().key;
                }
                st.add(new Pair(i,arr[i]));
            }
        }
        for (int i = 0; i<res.length; i++) {
            res[i] = i - res[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{100, 80, 60, 70, 60, 75, 85};
        System.out.println(Arrays.toString(calculateSpan(arr, arr.length)));
    }
}

package datastructure.stack;


import java.util.*;

/**
 * Nearest Greater Element to Right
 *
 * Input:
 * N = 4, arr[] = [1 3 2 4]
 * Output:
 * 3 4 4 -1
 *
 * Expected Time Complexity : O(N)
 * Expected Auxiliary Space : O(N)
 */
class MostOptimisedSol {
    public static long[] nextLargerElement(long[] arr, int n)
    {
        Stack<Long> s = new Stack<>();
        long[] nge = new long[n];

        //traversing the array from last element in backward direction.
        for (int i = n - 1; i >= 0; i--)
        {
            if (!s.empty())
            {
                //while element at top of stack is less than or equal to
                //current array element, we pop elements from the stack.
                while (!s.empty() && s.peek() <= arr[i]) {
                    s.pop();
                }
            }
            //if stack becomes empty, we store -1 in the answer list
            //else we store the top element of the stack.
            nge[i] = s.empty() ? -1 : s.peek();

            //pushing the current array element into the stack.
            s.push(arr[i]);
        }
        //returning the list.
        return nge;

    }
}

/**
 * //////// 50% correct solution
 */
public class NearestGreaterElement {
    public static void reverse(long[] res) {
        int lo = 0;
        int hi = res.length-1;
        while(lo<hi) {
            int temp = lo;
            lo = hi;
            hi = temp;
            lo++;
            hi--;
        }
    }
    public static long[] nextLargerElement(long[] arr, int n) {
        long[] res = new long[n];
        List<Integer> res1 = new ArrayList<>();
        Stack<Long> st = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            if(st.empty()) {
                res[i] = -1;
                st.push(arr[i]);
            } else if (st.size() > 0 && st.peek() > arr[i]) {
//                res1.add(i, st.peek());
                res[i] = st.peek();
                st.push(arr[i]);
            } else if (st.size() > 0 && st.peek() <= arr[i]) {
//                st.pop();
//                if(st.empty()) {
//                    res[i] = -1;
//                }
////                res[i] = st.peek();
//                st.push(arr[i]);

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
        reverse(res);
        return res;
    }

    public static void main(String[] args) {
        long[] arr = new long[]{7, 8, 1, 4};
        System.out.println(Arrays.toString(nextLargerElement(arr, arr.length)));
    }
}
/**
 * Time Complexity : O(N^2)
 * Space Complexity: O(N)
 */
class BruteForce {
    public static long[] nextLargerElement(long[] arr, int n)
    {
        // Your code here
        long[] res = new long[n];

        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; i < n; j++) {
                if(arr[j] > arr[i]) {
                    res[i] = arr[j];
                    break;
                }
            }
        }
        res[n-1] = -1;
        return res;
    }
}
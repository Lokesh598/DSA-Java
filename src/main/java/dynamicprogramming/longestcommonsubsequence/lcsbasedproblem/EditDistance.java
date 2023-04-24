package dynamicprogramming.longestcommonsubsequence.lcsbasedproblem;

public class EditDistance {
    static int[][] tb;
    public static int lcs(int x, int y, String s1, String s2) {
        tb = new int[x+1][y+1];
        for(int i = 0; i<x+1; i++) {
            for(int j = 0; j<y+1; j++) {
                if(i == 0 || j == 0)
                    tb[i][j] = 0;
            }
        }
        for(int i = 1; i<x+1; i++) {
            for (int j = 1; j < y + 1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    tb[i][j] = tb[i-1][j-1];
                } else {
                    tb[i][j] =1 + Math.min(tb[i-1][j], Math.min(tb[i][j-1],
                            tb[i-1][j-1]));
                }
            }
        }
        return tb[x][y];
    }

    public int editDistance(String s, String t) {
        // Code here
        int s1 = s.length();
        int s2 = t.length();

        int lcs = lcs(s.length(), t.length(), s, t);
        // System.out.println(lcs);
        // if(s1>s2)
        return lcs;
        // else
        // return s2-lcs;
    }
}

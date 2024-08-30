import java.util.Arrays;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] memo = new int[n + 1][m + 1];
        
        // Initialize the memoization table
        for (int[] arr : memo) Arrays.fill(arr, -1);

        int temp = lcsmemo(text1, text2, n, m, memo);
    
        // Reconstruct and print the LCS
        System.out.println(reconstructLCS(text1, text2, n, m, memo));

        // Compute the LCS length
        return temp;
        
    }
    
    private int lcsmemo(String text1, String text2, int n, int m, int[][] memo) {
        if (n == 0 || m == 0) {
            return 0;
        }
        
        if (memo[n][m] != -1) {
            return memo[n][m];
        }
        
        int lcs = 0;
        if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
            lcs = 1 + lcsmemo(text1, text2, n - 1, m - 1, memo);
        } else {
            lcs = Math.max(lcsmemo(text1, text2, n - 1, m, memo), lcsmemo(text1, text2, n, m - 1, memo));
        }
        
        return memo[n][m] = lcs;
    }
    
    private String reconstructLCS(String text1, String text2, int n, int m, int[][] memo) {
        StringBuilder lcs = new StringBuilder();
        while (n > 0 && m > 0) {
            if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
                lcs.append(text1.charAt(n - 1));
                n--;
                m--;
            } else if (memo[n - 1][m] > memo[n][m - 1]) {
                n--;
            } else {
                m--;
            }
        }
        return lcs.reverse().toString();
    }
}

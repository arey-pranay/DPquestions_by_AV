import java.util.Arrays;

class Solution {
    // Define a memoization table
    private Integer[][] memo;
    
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // Initialize the memoization table with null values
        memo = new Integer[m][n];
        
        // Start the recursive function with memoization
        return func(text1, text2, 0, 0);
    }
    
    // Recursive function with memoization
    public int func(String text1, String text2, int i, int j) {
        // Base case: If either string is exhausted
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        
        // If the result is already computed, return it from the memoization table
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        // If characters match, move both pointers and increase count
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + func(text1, text2, i + 1, j + 1);
        } else {
            // If characters don't match, try both possibilities: skip one character from either string
            memo[i][j] = Math.max(func(text1, text2, i + 1, j), func(text1, text2, i, j + 1));
        }
        
        return memo[i][j];
    }
}

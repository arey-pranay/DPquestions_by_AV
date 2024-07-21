public class MinDeletionsToPalindrome {

    // Function to find the length of the Longest Common Subsequence (LCS)
    public static int lcs(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Build the dp array from the bottom up
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0; // Base case: if one string is empty, LCS is 0
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // Characters match
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Characters don't match
                }
            }
        }

        // The value at dp[m][n] contains the length of LCS of str1 and str2
        return dp[m][n];
    }

    // Function to find the minimum number of deletions to make a substring palindrome
    public static int minDeletionsToPalindrome(String s) {
        // The reverse of the string
        String reverseS = new StringBuilder(s).reverse().toString();
        
        // The length of the Longest Palindromic Subsequence (LPS)
        int lpsLength = lcs(s, reverseS);
        
        // The minimum deletions needed
        return s.length() - lpsLength;
    }

    public static void main(String[] args) {
        String s = "abcbg";
        System.out.println("Minimum deletions to make substring palindrome: " + minDeletionsToPalindrome(s));
    }
}

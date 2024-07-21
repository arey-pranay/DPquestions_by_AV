public class LongestRepeatingSubsequence {

    // Function to find the length of the Longest Repeating Subsequence (LRS)
    public static int longestRepeatingSubsequence(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        // Build the dp array from the bottom up
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // Characters match and not the same position
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Characters don't match
                }
            }
        }

        // The value at dp[n][n] contains the length of LRS of the entire string
        return dp[n][n];
    }

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println("Length of Longest Repeating Subsequence is " + longestRepeatingSubsequence(s));
    }
}

public class Solution {

    public int minCut(String s) {
        int n = s.length();
        // dp[i] will store the minimum cuts needed for substring s[0...i-1]
        int[] dp = new int[n];
        // isPalindrome[i][j] will be true if s.substring(i, j + 1) is a palindrome
        boolean[][] isPalindrome = new boolean[n][n];

        // Initialize the dp array with maximum possible cuts
        for (int i = 0; i < n; i++) {
            dp[i] = i; // Maximum cuts needed for s[0...i] is i
        }

        // Calculate palindrome information for all substrings
        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                // Check if substring s[start...end] is a palindrome
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || isPalindrome[start + 1][end - 1])) {
                    isPalindrome[start][end] = true;
                }
            }
        }

        // Fill dp array using the palindrome information
        for (int i = 1; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0; // No cuts needed if s[0...i] itself is a palindrome
            } else {
                for (int j = 1; j <= i; j++) {
                    if (isPalindrome[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }

        // Minimum cuts needed for the whole string s
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aab";
        System.out.println("Minimum cuts needed: " + solution.minCut(s)); // Output: 1
    }
}

public class LongestCommonSubstringTabulated {
    public static int longestCommonSubstring(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0; // To store the length of the longest common substring

        // Build the dp array from the bottom up
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0; // Base case: if one string is empty, LCSubstring is 0
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // Characters match, extend the length of substring
                    maxLength = Math.max(maxLength, dp[i][j]); // Update max length if needed
                } else {
                    dp[i][j] = 0; // Characters don't match, reset the length of substring
                }
            }
        }

        // The value of maxLength contains the length of the longest common substring
        return maxLength;
    }

    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        System.out.println("Length of Longest Common Substring is " + longestCommonSubstring(str1, str2));
    }
}

public class ShortestCommonSupersequence {

    // Function to find the length of the Longest Common Subsequence (LCS)
    public static int lcs(String str1, String str2, int[][] dp) {
        int m = str1.length();
        int n = str2.length();

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

    // Function to find and print the Shortest Common Supersequence (SCS)
    public static String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Find the LCS length and fill the dp array
        lcs(str1, str2, dp);

        // Build the SCS from the dp array
        StringBuilder scs = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                scs.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                scs.append(str1.charAt(i - 1));
                i--;
            } else {
                scs.append(str2.charAt(j - 1));
                j--;
            }
        }

        // Add remaining characters of str1
        while (i > 0) {
            scs.append(str1.charAt(i - 1));
            i--;
        }

        // Add remaining characters of str2
        while (j > 0) {
            scs.append(str2.charAt(j - 1));
            j--;
        }

        // The result is in reverse order
        return scs.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "abac";
        String str2 = "cab";
        String scs = shortestCommonSupersequence(str1, str2);
        System.out.println("Shortest Common Supersequence is " + scs);
    }
}

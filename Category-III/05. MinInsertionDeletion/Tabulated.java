public class MinInsertDelete {

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

    // Function to find the minimum number of insertions and deletions
    public static int[] minInsertDelete(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Find the LCS length and fill the dp array
        int lcsLength = lcs(str1, str2, dp);

        // Calculate the number of deletions and insertions
        int deletions = m - lcsLength;
        int insertions = n - lcsLength;

        return new int[]{deletions, insertions};
    }

    public static void main(String[] args) {
        String str1 = "heap";
        String str2 = "pea";
        int[] result = minInsertDelete(str1, str2);
        System.out.println("Minimum deletions: " + result[0]);
        System.out.println("Minimum insertions: " + result[1]);
    }
}

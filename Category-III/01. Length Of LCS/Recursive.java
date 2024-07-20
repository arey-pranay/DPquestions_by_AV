public class LongestCommonSubsequenceRecursive {
    public static int lcs(String str1, String str2, int m, int n) {
        // Base case: if either string is empty
        if (m == 0 || n == 0) {
            return 0;
        }

        // If last characters of both strings match
        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return 1 + lcs(str1, str2, m - 1, n - 1);
        } else {
            // If last characters do not match
            return Math.max(lcs(str1, str2, m - 1, n), lcs(str1, str2, m, n - 1));
        }
    }

    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        int m = str1.length();
        int n = str2.length();
        System.out.println("Length of LCS is " + lcs(str1, str2, m, n));
    }
}

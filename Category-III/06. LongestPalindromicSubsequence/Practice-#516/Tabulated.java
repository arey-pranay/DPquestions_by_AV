class Solution {
    public int longestPalindromeSubseq(String s) {

        int m = s.length();
        StringBuilder temp = new StringBuilder(s);
        String s2 = temp.reverse().toString();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0) dp[i][j] = 0;
                else if(s.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}

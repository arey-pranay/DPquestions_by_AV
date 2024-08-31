class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0) dp[i][j] = 0;
                else if(X.charAt(i-1) == Y.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        //printing the scs string
        int i = m;
        int j = n;
        StringBuilder scs = new StringBuilder();
        while(i>0 && j>0){
            if(X.charAt(i-1)==Y.charAt(j-1)){
                scs.append(X.charAt(i-1)); //or Y.charAt(j-1);
                i--;
                j--;
            } else if(dp[i-1][j] > dp[i][j-1]){
                scs.append(X.charAt(i-1));
                i--;
            } else {
                scs.append(Y.charAt(j-1));
                j--;
            }
        }
        while(i>0){
            scs.append(X.charAt(i-1));
            i--;
        }
        while(j>0){
            scs.append(Y.charAt(j-1));
            j--;
        }
        scs = scs.reverse();
        System.out.println(scs);
        return scs.length();
        // return m+n-dp[m][n];
    }
}

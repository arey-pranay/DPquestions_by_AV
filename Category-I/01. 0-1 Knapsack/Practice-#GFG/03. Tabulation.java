class Solution {
    static int knapSack(int W, int[] wt, int[] val) {
    int n = wt.length;
    int Max = W;
    int[][] dp = new int[Max + 1][n + 1];

    // Fill the dp table
    for (int i = 0; i < n; i++) {
        for (int cap = 0; cap <= Max; cap++) {
            if (wt[i] > cap) {
                dp[cap][i + 1] = dp[cap][i]; // Can't take this item, so inherit the value without this item
            } else {
                int take = val[i] + dp[cap - wt[i]][i]; // Value if we take the item
                int notTake = dp[cap][i]; // Value if we don't take the item
                dp[cap][i + 1] = Math.max(take, notTake); // Max of taking or not taking the item
            }
        }
    }
    for(int[] arr : dp){
        for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    
    // The result is in dp[W][n]
    return dp[Max][n];

}

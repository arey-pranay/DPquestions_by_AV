class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        //take or not take
        int n = wt.length; // Number of items
        int[][] dp = new int[n + 1][W + 1]; // DP table initialization
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0; // Base case: no items or zero capacity
                } else if (wt[i - 1] <= w) {
                    // Option 1: Include the item
                    int include = val[i - 1] + dp[i - 1][w - wt[i - 1]];
                    // Option 2: Exclude the item
                    int exclude = dp[i - 1][w];
                    dp[i][w] = Math.max(include, exclude);
                } else {
                    // If the item cannot be included
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        return dp[n][W];
        
        
      }
}

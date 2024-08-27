class Solution{
   public int cutRod(int price[], int n) {
        // Call the recursive function with initial parameters
        int[][] memo = new int[n+1][n+1];
        for(int[] arr : memo) Arrays.fill(arr,-1);
        return func(price, n, 0,memo);
    }

    static int func(int price[], int n, int curr, int[][] memo) {
        // Base case: If the rod length is 0, no profit can be made
        if (n == 0) {
            return 0;
        }
        
        // Base case: If curr exceeds the length of the price array, return 0
        if (curr >= n) {
            return 0;
        }
        
        if(memo[n][curr] != -1) return memo[n][curr];
        
        // Option 1: Do not cut the rod at this curr
        int notCut = func(price, n, curr + 1,memo);

        // Option 2: Cut the rod at this curr (if possible)
        int cut = Integer.MIN_VALUE;
        int rodLength = curr + 1; // length corresponding to this curr
        if (rodLength <= n) {
            cut = price[curr] + func(price, n - rodLength, curr,memo);
        }

        // Return the maximum of not cutting and cutting
        memo[n][curr] = Math.max(notCut, cut);
        return memo[n][curr];
    }
}

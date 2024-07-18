public class SubsetSum {
    
    public static boolean subsetSumExists(int[] nums, int targetSum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][targetSum + 1];
        
        // Base case: subset with sum 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        
        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= targetSum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        
        return dp[n][targetSum];
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 9, 12};
        int targetSum = 8;
        boolean exists = subsetSumExists(nums, targetSum);
        System.out.println("Subset with sum " + targetSum + " exists: " + exists);
    }
}

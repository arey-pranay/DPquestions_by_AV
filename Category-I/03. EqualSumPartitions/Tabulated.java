public class EqualSumPartition {
    
    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // If total sum is odd, cannot partition into two equal subsets
        if (totalSum % 2 != 0) {
            return false;
        }
        
        int targetSum = totalSum / 2;
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
        int[] nums = {1, 5, 11, 5};
        boolean canPartition = canPartition(nums);
        System.out.println("Can partition into equal subsets: " + canPartition);
    }
}

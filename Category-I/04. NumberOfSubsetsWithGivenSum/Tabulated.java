public class CountSubsetsWithSum {
    
    public static int countSubsets(int[] nums, int targetSum) {
        int n = nums.length;
        int[][] dp = new int[n + 1][targetSum + 1];
        
        // Base case: There's always one way to achieve sum 0 (by choosing no elements)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= targetSum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        
        return dp[n][targetSum];
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 10};
        int targetSum = 16;
        int count = countSubsets(nums, targetSum);
        System.out.println("Number of subsets with sum " + targetSum + ": " + count);
    }
}

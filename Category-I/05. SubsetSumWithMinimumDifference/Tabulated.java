 
// public class MinimumSubsetSumDifference {
    
//     public static int minSubsetSumDifference(int[] nums) {
//         int n = nums.length;
//         int totalSum = 0;
        
//         // Calculate the total sum of the array
//         for (int num : nums) {
//             totalSum += num;
//         }
        
//         // Initialize a DP array to store possible subset sums
//         boolean[][] dp = new boolean[n + 1][totalSum + 1];
        
//         // Initialize base case: subset sum 0 is always possible
//         for (int i = 0; i <= n; i++) {
//             dp[i][0] = true;
//         }
        
//         // Fill the DP table
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= totalSum; j++) {
//                 dp[i][j] = dp[i - 1][j];
//                 if (j >= nums[i - 1]) {
//                     dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
//                 }
//             }
//         }
        
//         // Find the minimum difference between subset sums
//         int lastValidIndex = 0;
// for (int j = 0; j <= totalSum / 2; j++) {
//             if (dp[n][j]) {
//                lastValidIndex++;
//             }
//         }
// return totalSum - 2 * lastValidIndex;
//     }
    
//     public static void main(String[] args) {
//         int[] nums = {1, 6, 11, 5};
//         int minDiff = minSubsetSumDifference(nums);
//         System.out.println("Minimum subset sum difference: " + minDiff);
//     }
// }

public class MinimumSubsetSumDifference {
    
    public static int minSubsetSumDifference(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        
        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }
        
        // Initialize a DP array to store possible subset sums
        boolean[][] dp = new boolean[n + 1][totalSum + 1];
        
        // Initialize base case: subset sum 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        
        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalSum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        
        // Find the minimum difference between subset sums
        int minDiff = Integer.MAX_VALUE;
        for (int j = 0; j <= totalSum / 2; j++) {
            if (dp[n][j]) {
                minDiff = Math.min(minDiff, totalSum - 2 * j);
            }
        }
        
        return minDiff;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 6, 11, 5};
        int minDiff = minSubsetSumDifference(nums);
        System.out.println("Minimum subset sum difference: " + minDiff);
    }
}

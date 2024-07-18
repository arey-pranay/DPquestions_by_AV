public class TargetSum {

    public static int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        int sum = 0;

        // Calculate the total sum of the array
        for (int num : nums) {
            sum += num;
        }

        // Check if it's possible to achieve the target sum
        // If the total sum plus S is odd, return 0 (impossible to partition)
        if ((sum + S) % 2 != 0) {
            return 0;
        }

        // Calculate the target sum for subset1
        int targetSum = (sum + S) / 2;

        // Initialize DP array to store number of ways
        int[] dp = new int[targetSum + 1];
        dp[0] = 1; // One way to achieve sum 0 (by choosing no elements)

        // Fill the DP table
        for (int num : nums) {
            // Iterate backwards to prevent overwriting the dp array for the current number in nums
            for (int j = targetSum; j >= num; j--) {
                // Update dp[j] based on whether num is added or subtracted
                dp[j] += dp[j - num];
            }
        }

        return dp[targetSum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3};
        int S = 1;
        
        // Calculate the number of ways to achieve the target sum
        int ways = findTargetSumWays(nums, S);
        
        // Print the result
        System.out.println("Number of ways to achieve sum " + S + ": " + ways);
    }
}

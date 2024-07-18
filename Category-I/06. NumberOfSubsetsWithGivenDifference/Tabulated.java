public class SubsetsWithGivenDifference {

    public static int countSubsetsWithDifference(int[] nums, int diff) {
        int n = nums.length;
        int totalSum = 0;

        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        // Calculate the target sum for subset1
        int targetSum = (diff + totalSum) / 2;

        // Initialize DP array to store number of subsets
        int[] dp = new int[targetSum + 1];
        dp[0] = 1; // One way to achieve sum 0 (by choosing no elements)

        // Fill the DP table
        for (int num : nums) {
            for (int j = targetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[targetSum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3};
        int diff = 1;
        int count = countSubsetsWithDifference(nums, diff);
        System.out.println("Number of subsets with difference " + diff + ": " + count);
    }
}

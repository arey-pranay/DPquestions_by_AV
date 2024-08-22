import java.util.Arrays;

class Solution {

    int mod = (int)1e9 + 7;
  public int countPartitions(int n, int d, int arr[]) {
        int totalSum = 0;

         // sum(s1) - sum(s2) = d
        // sum(s1) + sum(s2) = sum(arr)
        // => sum(s1)  = (d + sum(arr)) /2
        // to find how many such s1 are possible
        // count number of subsets with sum = sum(s1)

        // Calculate the total sum of the array
        for (int i = 0; i < n; ++i) {
            totalSum += arr[i];
        }

        // Check for invalid cases
        if (totalSum < d || (totalSum - d) % 2 != 0) {
            return 0;
        }

        // Calculate the target sum for subset
        int target = (totalSum - d) / 2;

        // Initialize memoization table
        int[][] memo = new int[n + 1][target + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Start solving the problem
        return solve(n, target, arr, memo);
    }
    // Recursive function with memoization
    int solve(int i, int sum, int[] arr, int[][] memo) {
        if (i == 0) {
            // Base case: If no elements left, we can only achieve sum 0 by selecting no elements
            return (sum == 0) ? 1 : 0;
        }

        // Return the result if already computed
        if (memo[i][sum] != -1) {
            return memo[i][sum];
        }

        // Count subsets not including the current element
        memo[i][sum] = solve(i - 1, sum, arr, memo);

        // Count subsets including the current element if sum allows
        if (sum >= arr[i - 1]) {
            memo[i][sum] = (memo[i][sum] + solve(i - 1, sum - arr[i - 1], arr, memo)) % mod;
        }

        return memo[i][sum];
    }

  
}

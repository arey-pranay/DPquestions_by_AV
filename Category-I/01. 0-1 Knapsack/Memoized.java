public class KnapsackMemoized {
    public static int knapsack(int[] weights, int[] values, int capacity, int n, int[][] dp) {
        // Base Case
        if (n == 0 || capacity == 0) {
            return 0;
        }

        // If the value is already calculated
        if (dp[n][capacity] != -1) {
            return dp[n][capacity];
        }

        // If weight of the nth item is more than knapsack capacity, it cannot be included
        if (weights[n-1] > capacity) {
            dp[n][capacity] = knapsack(weights, values, capacity, n-1, dp);
        } else {
            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
            dp[n][capacity] = Math.max(
                values[n-1] + knapsack(weights, values, capacity - weights[n-1], n-1, dp),
                knapsack(weights, values, capacity, n-1, dp)
            );
        }
        
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;
        int n = values.length;
        int[][] dp = new int[n+1][capacity+1];
        
        // Initialize dp array with -1
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < capacity+1; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(knapsack(weights, values, capacity, n, dp));
    }
}

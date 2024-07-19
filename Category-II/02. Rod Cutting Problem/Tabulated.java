// Completely Same as the Unbounded Knapsack

public class KnapsackTabulated {
    public static int knapsack(int[] weights, int[] values, int capacity, int n) {
        int[][] dp = new int[n+1][capacity+1];

        // Build table dp[][] in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i-1] <= w) {
                    dp[i][w] = Math.max(
                        values[i-1] + dp[i][w - weights[i-1]],
                        dp[i-1][w]
                    );
                } else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;
        int n = values.length;
        System.out.println(knapsack(weights, values, capacity, n));
    }
}

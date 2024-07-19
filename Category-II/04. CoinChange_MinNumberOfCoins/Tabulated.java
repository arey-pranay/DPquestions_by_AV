import java.util.Arrays;

public class CoinChangeMinimumCoins {

    // Function to find the minimum number of coins needed
    // to make up a given amount using a given set of coins
    static int minCoins(int[] coins, int amount) {
        // Create an array to store the minimum number of coins
        // needed to make up each amount from 0 to amount
        int[] dp = new int[amount + 1];

        // Initialize all entries as Infinite (or unreachable)
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Base case: 0 coins are needed for amount 0
        dp[0] = 0;

        // Compute minimum coins required for all values from 1 to amount
        for (int i = 1; i <= amount; i++) {
            // Go through all coins smaller than or equal to i
            for (int coin : coins) {
                if (coin <= i) {
                    int subResult = dp[i - coin];
                    if (subResult != Integer.MAX_VALUE && subResult + 1 < dp[i]) {
                        dp[i] = subResult + 1;
                    }
                }
            }
        }

        // dp[amount] will contain the minimum number of coins needed
        // to make up the amount using the given coins
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 25}; // Example set of coins
        int amount = 32; // Example amount to make up

        int minCoinsNeeded = minCoins(coins, amount);
        System.out.println("Minimum number of coins needed: " + minCoinsNeeded);
    }
}

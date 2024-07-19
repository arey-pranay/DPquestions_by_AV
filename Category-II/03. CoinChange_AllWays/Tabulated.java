import java.util.Arrays;

public class CoinChangeWays {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5}; // Example denominations
        int amount = 5; // Example amount to make change for

        int ways = countWays(coins, amount);
        System.out.println("Number of ways to make change: " + ways);
    }

    public static int countWays(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // There is one way to make amount 0, which is using no coins

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}


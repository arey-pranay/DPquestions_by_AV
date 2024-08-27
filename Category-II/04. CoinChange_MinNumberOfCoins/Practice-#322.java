class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = func(coins, amount, 0, 0, 0);
        return ans == Integer.MAX_VALUE ? -1 :  ans;
    }
    public int func(int[] coins, int amount, int currAmount, int i, int n){
        if(currAmount == amount) return n;
        if(currAmount > amount) return Integer.MAX_VALUE;
        if(i == coins.length) return Integer.MAX_VALUE;
        int notTake = func(coins, amount, currAmount, i+1, n);
        int take = func(coins, amount, currAmount + coins[i], i, n+1);
        return Math.min(notTake, take);
    }
}

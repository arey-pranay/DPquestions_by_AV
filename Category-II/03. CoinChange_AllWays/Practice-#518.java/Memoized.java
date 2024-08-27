class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[amount][coins.length];
        for(int[] arr : memo)Arrays.fill(arr,-1);
        return func(amount, coins, 0,0,memo);
    }
    //I start from 0th index, with having to make amount
    //Then I either take or not take this index, and try both ways, and return whatever is the max value of this
    //whenever my currAmount == amount, I get a new way of getting to ans
    //if index == coins.length then return 0 coz this doesn't give a valid way
    //if amount < 0 return 0 coz this doesn't give a valid way
    //otherwise just keep checking by adding the coins[index] in your amount vs not adding it
    public int func(int amount, int[] coins, int i, int currAmount, int[][]memo){
        if(currAmount == amount) return 1;
        if(i == coins.length) return 0;
        if(currAmount > amount) return 0;
        if(memo[currAmount][i] != -1) return memo[currAmount][i];
        int notTake = func(amount, coins, i+1, currAmount,memo);
        int take = func(amount, coins, i, currAmount + coins[i],memo);
        memo[currAmount][i] = notTake + take;
        return  memo[currAmount][i];
    }
}

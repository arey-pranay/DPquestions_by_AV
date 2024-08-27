class Solution {
    public int change(int amount, int[] coins) {
        return func(amount, coins, 0,0);
    }
    //I start from 0th index, with having to make amount
    //Then I either take or not take this index, and try both ways, and return whatever is the max value of this
    //whenever my currAmount == amount, I get a new way of getting to ans
    //if index == coins.length then return 0 coz this doesn't give a valid way
    //if amount < 0 return 0 coz this doesn't give a valid way
    //otherwise just keep checking by adding the coins[index] in your amount vs not adding it
    public int func(int amount, int[] coins, int i, int currAmount){
        if(currAmount == amount) return 1;
        if(i == coins.length) return 0;
        if(currAmount > amount) return 0;
        int notTake = func(amount, coins, i+1, currAmount);
        int take = func(amount, coins, i, currAmount + coins[i]);
        return notTake + take;
    }
}

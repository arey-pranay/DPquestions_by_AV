
class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int N, int W, int val[], int wt[]) {
        //take or not take
        
        //let's say there is a variable i that is acting as a choice pointer. Currently it's at 0, so I need to decide whether to take 0 or not, or can I even take it possibly.
        
        //First and foremost if I get to the of the array I need to return that profit after this is 0
        //firstly if the weight of 0th element exceeds the capacity (W) then I need to skip it and move ahead.
        //Option 1: say I take 0th element, now the problem becomes a smaller version of the same problem, but remaining weight is decreased and 1 choice is decreased
        //Let's say I do not take the 0th element, now Weight is same but the choices pointer is incremented.
        //at the end I just need to choose the one which gave max profit
        int[][] memo = new int[W+1][N+1];
        for(int[] temp : memo) Arrays.fill(temp,-1);
        return func(W, wt, val, 0,memo);
        
    }
    // func returns the profit if you start from ith index with W weight remaining to be filled by considering the above cases
    public static int func(int W, int[] wt, int[] val, int i, int[][] memo){ 
        
        if(memo[W][i] != -1) return memo[W][i];
        if(i>= wt.length) return 0;
        
        if (wt[i] > W) {
            memo[W][i] = func(W, wt, val, i + 1,memo);
            return memo[W][i];
        }
        
        int take    = func(W-wt[i], wt, val, i,memo) + val[i] ;
        int notTake = func(W, wt, val, i+1, memo);
        
        memo[W][i] = Math.max(take ,notTake);
        return memo[W][i];
    }
}

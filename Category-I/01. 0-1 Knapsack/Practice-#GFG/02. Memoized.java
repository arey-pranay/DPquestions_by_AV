class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        //take or not take
        
        //let's say there is a variable i that is acting as a choice pointer. Currently it's at 0, so I need to decide whether to take 0 or not, or can I even take it possibly.
        
        // First and foremost if I get to the of the array I need to return that profit after this is 0
        // firstly if the weight of 0th element exceeds the capacity (W) then I need to skip it and move ahead.
        // Option 1: say I take 0th element, now the problem becomes a smaller version of the same problem, but remaining weight is decreased and 1 choice is decreased
        // Let's say I do not take the 0th element, now Weight is same but the choices pointer is incremented.
        // at the end I just need to choose the one which gave max profit
        
       // Recursive Approach: return rec(W, wt, val, 0);
        
        // now to memoize, I need to consider how many variables are changing in the function call, because then they define the "state" of a problem, i.e., a proper subproblem
        // in this case, the i changes in each call, and W changes whenever we take the ith element, so 2 variables, so 2 dimensions, so that we can have answers for all pairs of i and W

        int[][] memo = new int[W+1][wt.length+1]; //wt.length+1 because we are checking i+1 every time, so if last+1 index does not exist in memo[W] in the last call we will get an exception of ArrayIndexOutOfBounds
        for(int[] arr : memo) Arrays.fill(arr,-1);
        return func(W, wt, val, 0, memo);
    }
   
    //func is same as rec but takes a memo 2D array ( or matrix ) that we will now use to store the result of every subproblem so that we can check before making a new function call
    public static int func(int W, int[] wt, int[] val, int i, int[][] memo){
        
        if(i>=wt.length || W<=0) return 0;
        
        if (memo[W][i] != -1) return memo[W][i];
        
        if (wt[i] > W) {
            memo[W][i] = func(W, wt, val, i + 1, memo);
        } else {
            int take = val[i] + func(W - wt[i], wt, val, i + 1, memo);
            int notTake = func(W, wt, val, i + 1, memo);
            memo[W][i] = Math.max(take, notTake);
        }

        return memo[W][i];
        
    }
    
    // rec returns the profit if you start from ith index with W weight remaining to be filled by considering the above cases
    public static int rec(int W, int[] wt, int[] val, int i){ 
        if(i>=wt.length) return 0;
        if (wt[i] > W) return rec(W, wt, val, i + 1);
        
        int take    = rec(W-wt[i], wt, val, i+1) + val[i] ;
        int notTake = rec(W, wt, val, i+1);
        
        return Math.max(take ,notTake);
    }   
}

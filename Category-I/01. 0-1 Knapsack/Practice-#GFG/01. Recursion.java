class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        //take or not take
        
        //let's say there is a variable i that is acting as a choice pointer. Currently it's at 0, so I need to decide whether to take 0 or not, or can I even take it possibly.
        
        //First and foremost if I get to the of the array I need to return that profit after this is 0
        //firstly if the weight of 0th element exceeds the capacity (W) then I need to skip it and move ahead.
        //Option 1: say I take 0th element, now the problem becomes a smaller version of the same problem, but remaining weight is decreased and 1 choice is decreased
        //Let's say I do not take the 0th element, now Weight is same but the choices pointer is incremented.
        //at the end I just need to choose the one which gave max profit
        
        return func(W, wt, val, 0);
        
    }
    // func returns the profit if you start from ith index with W weight remaining to be filled by considering the above cases
    public static int func(int W, int[] wt, int[] val, int i){ 
        if(i>=wt.length) return 0;
        if (wt[i] > W) return func(W, wt, val, i + 1);
        
        int take    = func(W-wt[i], wt, val, i+1) + val[i] ;
        int notTake = func(W, wt, val, i+1);
        
        return Math.max(take ,notTake);
    }
}

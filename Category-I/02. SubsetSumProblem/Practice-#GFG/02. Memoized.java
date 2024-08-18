class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // we have N numbers, we need to create sum
        // take or not take N
        // if you take N, sum becomes sum-N and i = i+1
        // if you do not take N, sum = sum and i = i+1, if sum == 0 return true;
        // return func(N, arr, sum, 0) == 1 ? true : false;
        //so the pointer (let's say, it is i) keeps changing and sum keeps changing, we will need 2D memo table in this
        int[][] memo = new int[sum+1][N+1];
        for(int[] temp: memo) Arrays.fill(temp,-1);
        return func(N, arr, sum, 0,memo) == 1 ? true : false;
    }
    static int func(int N, int[] arr, int sum, int i, int[][] memo){
        if(sum==0) return 1;
        if(sum<0) return 0;
        if(i==N) return 0;
        if(memo[sum][i] != -1) return memo[sum][i];
        int take = func(N, arr, sum-arr[i], i+1, memo);
        int notTake = func(N, arr, sum, i+1, memo);
        memo[sum][i] = take | notTake;
        return memo[sum][i]; //so that if any call returns true, you will get true only
    }
    static int rec(int N, int[] arr, int sum, int i){
        if(sum==0) return 1;
        if(sum<0) return 0;
        if(i==N) return 0;
        int take = rec(N, arr, sum-arr[i], i+1);
        int notTake = rec(N, arr, sum, i+1);
        return take | notTake; //so that if any call returns true, you will get true only
    }
}


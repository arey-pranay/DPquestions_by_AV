class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        //we need 2 parts of this array to have same sum, 
        //that means that each part will have sumOfTheEntireArry/2 sum
        //so it's the same as the subset sum problem where you need to find sum/2
        //and in that also, before calling function, check if the sum is odd and directly return false in that particular case
        
        int sum = 0;
        for(int i: arr) sum+= i;
        if(sum%2 != 0) return 0;
        return isSubsetSum(N, arr, sum/2);
    }
    static int isSubsetSum(int N, int arr[], int sum){
        // we have N numbers, we need to create sum
        // take or not take N
        // if you take N, sum becomes sum-N and i = i+1
        // if you do not take N, sum = sum and i = i+1, if sum == 0 return true;
        // return func(N, arr, sum, 0) == 1 ? true : false;
        //so the pointer (let's say, it is i) keeps changing and sum keeps changing, we will need 2D memo table in this
        int[][] memo = new int[sum+1][N+1];
        for(int[] temp: memo) Arrays.fill(temp,-1);
        return func(N, arr, sum, 0,memo);
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
}

public class Solution {
    public static int findWays(int num[], int tar) {
        // Write your code here.
        int[][] memo = new int[tar+1][num.length+1];
        for(int[] temp: memo) Arrays.fill(temp,-1);
        return func(num.length, num, tar, 0,memo);
    }
    public static int func(int N, int[] arr, int sum, int i, int[][] memo){
        if(sum==0) return 1;
        if(sum<0) return 0;
        if(i==N) return 0;
        if(memo[sum][i] != -1) return memo[sum][i];
        int take = func(N, arr, sum-arr[i], i+1, memo);
        int notTake = func(N, arr, sum, i+1, memo);
        memo[sum][i] = take + notTake;
        return memo[sum][i]; //so that if any call returns true, you will get true only
    }
}

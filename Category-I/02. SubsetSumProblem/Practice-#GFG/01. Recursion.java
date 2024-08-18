class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // we have N numbers, we need to create sum
        // take or not take N
        // if you take N, sum becomes sum-N and i = i+1
        // if you do not take N, sum = sum and i = i+1, if sum == 0 return true;
        return func(N, arr, sum, 0) == 1 ? true : false;
        //so the pointer (let's say, it is i) keeps changing and sum keeps changing, we will need 2D memo table in this
        // int[][] memo = new int[sum+1][N+1];
    }
    static int func(int N, int[] arr, int sum, int i){
        if(sum==0) return 1;
        if(sum<0) return 0;
        if(i==N) return 0;
        int take = func(N, arr, sum-arr[i], i+1);
        int notTake = func(N, arr, sum, i+1);
        return take | notTake; //so that if any call returns true, you will get true only
    }
}

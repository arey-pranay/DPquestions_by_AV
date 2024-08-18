class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // we have N numbers, we need to create sum
        // take or not take N
        // if you take N, sum becomes sum-N and i = i+1
        // if you do not take N, sum = sum and i = i+1, if sum == 0 return true;
        return func(N, arr, sum, 0);
    }
    static Boolean func(int N, int[] arr, int sum, int i){
        if(sum==0) return true;
        if(sum<0) return false;
        if(i==N) return false;
        boolean take = func(N, arr, sum-arr[i], i+1);
        boolean notTake = func(N, arr, sum, i+1);
        return take || notTake; //so that if any call returns true, you will get true only
    }
}

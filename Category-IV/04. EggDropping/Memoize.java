import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int superEggDrop(int K, int N) {
        // Memoization map: key is (K, N)
        Map<String, Integer> memo = new HashMap<>();
        return dropEgg(K, N, memo);
    }
    
    private int dropEgg(int K, int N, Map<String, Integer> memo) {
        // Base cases
        // If there is only one egg, we have to do N trials in worst case
        if (K == 1) return N;
        // If there is only one floor or zero floors, we only need one trial
        if (N == 0 || N == 1) return N;
        
        // Check memoization map
        String key = K + "_" + N;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int minTrials = Integer.MAX_VALUE;
        
        // Perform binary search over floors
        int low = 1, high = N;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            int breaks = dropEgg(K - 1, mid - 1, memo); // Egg breaks at floor `mid`
            int doesNotBreak = dropEgg(K, N - mid, memo); // Egg does not break at floor `mid`
            
            int worstOutcome = 1 + Math.max(breaks, doesNotBreak); // 1 for current trial
            
            if (breaks < doesNotBreak) {
                low = mid + 1; // We need to go higher
            } else {
                high = mid - 1; // We need to go lower
            }
            
            minTrials = Math.min(minTrials, worstOutcome);
        }
        
        // Memoize the result
        memo.put(key, minTrials);
        
        return minTrials;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int K = 2; // Number of eggs
        int N = 10; // Number of floors
        System.out.println("Minimum number of trials: " + solution.superEggDrop(K, N)); // Output: 4
    }
}

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int countWays(String expression) {
        int n = expression.length();
        // Memoization cache
        Map<String, Integer> memoTrue = new HashMap<>();
        Map<String, Integer> memoFalse = new HashMap<>();
        
        // Calculate the number of ways to parenthesize the entire expression
        return countWays(expression, 0, n - 1, true, memoTrue, memoFalse);
    }
    
    private int countWays(String expression, int start, int end, boolean isTrue,
                          Map<String, Integer> memoTrue, Map<String, Integer> memoFalse) {
        // Base case: If the subexpression is a single character
        if (start == end) {
            if (isTrue) {
                return (expression.charAt(start) == 'T') ? 1 : 0;
            } else {
                return (expression.charAt(start) == 'F') ? 1 : 0;
            }
        }
        
        // Create a unique key for memoization based on start, end, and isTrue
        String key = start + "_" + end + "_" + isTrue;
        if (isTrue && memoTrue.containsKey(key)) {
            return memoTrue.get(key);
        } else if (!isTrue && memoFalse.containsKey(key)) {
            return memoFalse.get(key);
        }
        
        int ways = 0;
        for (int k = start + 1; k <= end - 1; k += 2) {
            int leftTrue = countWays(expression, start, k - 1, true, memoTrue, memoFalse);
            int leftFalse = countWays(expression, start, k - 1, false, memoTrue, memoFalse);
            int rightTrue = countWays(expression, k + 1, end, true, memoTrue, memoFalse);
            int rightFalse = countWays(expression, k + 1, end, false, memoTrue, memoFalse);
            
            if (expression.charAt(k) == '&') {
                if (isTrue) {
                    ways += leftTrue * rightTrue;
                } else {
                    ways += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
                }
            } else if (expression.charAt(k) == '|') {
                if (isTrue) {
                    ways += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
                } else {
                    ways += leftFalse * rightFalse;
                }
            } else if (expression.charAt(k) == '^') {
                if (isTrue) {
                    ways += leftTrue * rightFalse + leftFalse * rightTrue;
                } else {
                    ways += leftTrue * rightTrue + leftFalse * rightFalse;
                }
            }
        }
        
        // Memoize the result
        if (isTrue) {
            memoTrue.put(key, ways);
        } else {
            memoFalse.put(key, ways);
        }
        
        return ways;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String expression = "T|T&F^T";
        System.out.println("Number of ways to parenthesize to true: " + solution.countWays(expression)); // Output: 4
    }
}

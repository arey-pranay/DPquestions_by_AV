import java.util.Arrays;

public class MatrixChainMultiplicationMemoized {
    
    // Matrix dimensions array
    static int[] dimensions = {10, 30, 5, 60};
    // Memoization table
    static int[][] memo;

    public static void main(String[] args) {
        int n = dimensions.length - 1; // number of matrices
        memo = new int[n + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        int minCost = matrixChainOrder(1, n);
        System.out.println("Minimum number of multiplications: " + minCost);
    }
    
    // Recursive function with memoization to calculate minimum number of multiplications
    static int matrixChainOrder(int i, int j) {
        if (i == j)
            return 0;
        
        if (memo[i][j] != -1)
            return memo[i][j];
        
        int minCost = Integer.MAX_VALUE;
        
        // Place parentheses at different places between first and last matrix,
        // recursively calculate the cost of each placement and return the minimum one.
        for (int k = i; k < j; k++) {
            int cost = matrixChainOrder(i, k) +
                       matrixChainOrder(k + 1, j) +
                       dimensions[i - 1] * dimensions[k] * dimensions[j];
            
            if (cost < minCost)
                minCost = cost;
        }
        
        // Memoize the result
        memo[i][j] = minCost;
        
        return minCost;
    }
}

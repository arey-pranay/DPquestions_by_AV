public class MatrixChainMultiplication {
  
    // Recursive function to calculate minimum number of multiplications
    static int matrixChainOrder(int i, int j) {
        if (i == j)
            return 0;
        
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
        
        return minCost;
    }
      // Matrix dimensions array
    static int[] dimensions = {10, 30, 5, 60};
    
    public static void main(String[] args) {
        int n = dimensions.length - 1; // number of matrices
        int minCost = matrixChainOrder(1, n);
        System.out.println("Minimum number of multiplications: " + minCost);
    }
    
}

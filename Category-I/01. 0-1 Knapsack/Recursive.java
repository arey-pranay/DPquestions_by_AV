public class KnapsackRecursive {
    public static int knapsack(int[] weights, int[] values, int capacity, int n) {
        // Base Case
        if (n == 0 || capacity == 0) {
            return 0;
        }
        
        // If weight of the nth item is more than knapsack capacity, it cannot be included
        if (weights[n-1] > capacity) {
            return knapsack(weights, values, capacity, n-1);
        } else {
            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
            return Math.max(
                values[n-1] + knapsack(weights, values, capacity - weights[n-1], n-1),
                knapsack(weights, values, capacity, n-1)
            );
        }
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;
        int n = values.length;
        System.out.println(knapsack(weights, values, capacity, n));
    }
}

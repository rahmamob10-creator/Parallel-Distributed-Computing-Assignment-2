public class CacheLocalityMatrixApp {
    private static final int SIZE = 2000;

    public static void main(String[] args) {
        System.out.println("--- Row-Major vs Column-Major Cache Locality Benchmark ---");
        int[][] matrix = new int[SIZE][SIZE];

        // Row-Major Traversal (Cache Friendly - Sequential Memory Access)
        long startRow = System.nanoTime();
        long sumRow = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sumRow += matrix[i][j];
            }
        }
        long endRow = System.nanoTime();

        // Column-Major Traversal (Cache Unfriendly - High L1/L2 Cache Misses)
        long startCol = System.nanoTime();
        long sumCol = 0;
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                sumCol += matrix[i][j];
            }
        }
        long endCol = System.nanoTime();

        double rowTimeMs = (endRow - startRow) / 1e6;
        double colTimeMs = (endCol - startCol) / 1e6;

        System.out.println("Row-Major Access Time: " + String.format("%.2f", rowTimeMs) + " ms");
        System.out.println("Column-Major Access Time: " + String.format("%.2f", colTimeMs) + " ms");
        System.out.println("Performance Advantage: " + String.format("%.2f", (colTimeMs / rowTimeMs)) + "x faster");
    }
}
/**
 * Thread-Safety Verification & Optimization
 * Target Module: CacheLocalityMatrixApp.java
 */

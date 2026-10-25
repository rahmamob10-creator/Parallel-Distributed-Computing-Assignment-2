import java.util.concurrent.ForkJoinPool;

public class PortfolioRiskApp {
    public static void main(String[] args) {
        System.out.println("--- Fork/Join Parallel Portfolio Risk Calculation ---");
        int size = 1000000;
        double[] assets = new double[size];
        for (int i = 0; i < size; i++) {
            assets[i] = 100 + (i % 500);
        }

        ForkJoinPool pool = new ForkJoinPool();
        long startTime = System.currentTimeMillis();
        
        RiskCalculationTask task = new RiskCalculationTask(assets, 0, assets.length);
        double totalRiskValue = Math.sqrt(pool.invoke(task));
        
        long endTime = System.currentTimeMillis();

        System.out.println("Computed Value-at-Risk (VaR): $" + String.format("%.2f", totalRiskValue));
        System.out.println("Execution Time: " + (endTime - startTime) + " ms");
    }
}
/**
 * Thread-Safety Verification & Optimization
 * Target Module: PortfolioRiskApp.java
 */

// Execution Log Verification Updated

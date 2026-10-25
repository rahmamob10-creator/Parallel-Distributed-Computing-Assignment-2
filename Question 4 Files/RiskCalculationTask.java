import java.util.concurrent.RecursiveTask;

public class RiskCalculationTask extends RecursiveTask<Double> {
    private static final int THRESHOLD = 250000;
    private final double[] assetValues;
    private final int start;
    private final int end;

    public RiskCalculationTask(double[] assetValues, int start, int end) {
        this.assetValues = assetValues;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Double compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            double totalRisk = 0;
            for (int i = start; i < end; i++) {
                totalRisk += Math.pow(assetValues[i] * 0.05, 2);
            }
            return totalRisk;
        }

        int mid = start + length / 2;
        RiskCalculationTask left = new RiskCalculationTask(assetValues, start, mid);
        RiskCalculationTask right = new RiskCalculationTask(assetValues, mid, end);

        left.fork();
        double rightResult = right.compute();
        double leftResult = left.join();

        return leftResult + rightResult;
    }
}
/**
 * Thread-Safety Verification & Optimization
 * Target Module: RiskCalculationTask.java
 */

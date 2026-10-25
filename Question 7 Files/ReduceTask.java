import java.util.Map;

public class ReduceTask {
    public static void printSummary(Map<String, Integer> wordCounts) {
        System.out.println("--- MapReduce Result Summary ---");
        wordCounts.forEach((word, count) -> 
            System.out.println("Word: '" + word + "' -> Count: " + count)
        );
    }
}

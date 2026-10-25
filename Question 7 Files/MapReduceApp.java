import java.util.Map;
import java.util.concurrent.ForkJoinPool;

public class MapReduceApp {
    public static void main(String[] args) {
        System.out.println("--- MapReduce Parallel Word Frequency Counter ---");

        String document = "parallel distributed computing java fork join multithreaded map reduce parallel java computing computing";
        String[] words = document.split(" ");

        ForkJoinPool pool = new ForkJoinPool();
        MapTask task = new MapTask(words, 0, words.length);

        Map<String, Integer> resultMap = pool.invoke(task);
        ReduceTask.printSummary(resultMap);
    }
}
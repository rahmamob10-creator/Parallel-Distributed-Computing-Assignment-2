import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

public class MapTask extends RecursiveTask<Map<String, Integer>> {
    private final String[] textSegment;
    private final int start;
    private final int end;

    public MapTask(String[] textSegment, int start, int end) {
        this.textSegment = textSegment;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Map<String, Integer> compute() {
        if (end - start <= 2) {
            Map<String, Integer> counts = new HashMap<>();
            for (int i = start; i < end; i++) {
                String word = textSegment[i].toLowerCase().replaceAll("[^a-zA-Z]", "");
                if (!word.isEmpty()) {
                    counts.put(word, counts.getOrDefault(word, 0) + 1);
                }
            }
            return counts;
        }

        int mid = start + (end - start) / 2;
        MapTask left = new MapTask(textSegment, start, mid);
        MapTask right = new MapTask(textSegment, mid, end);

        left.fork();
        Map<String, Integer> rightRes = right.compute();
        Map<String, Integer> leftRes = left.join();

        leftRes.forEach((key, val) -> rightRes.merge(key, val, Integer::sum));
        return rightRes;
    }
}
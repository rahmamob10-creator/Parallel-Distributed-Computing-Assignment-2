import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class PacketSymmetryChecker {

    public static boolean isSymmetricSequence(int[] payloadStream) {
        Deque<Integer> stack = new ArrayDeque<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int b : payloadStream) {
            stack.push(b);
            queue.add(b);
        }

        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) {
                return false;
            }
        }
        return true;
    }
}
import java.util.LinkedList;
import java.util.Queue;

public class OrderBook {
    private final Queue<String> orders = new LinkedList<>();
    private final int capacity;

    public OrderBook(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(String order) throws InterruptedException {
        while (orders.size() == capacity) {
            wait();
        }
        orders.add(order);
        System.out.println("[PRODUCED] " + order + " | Depth: " + orders.size());
        notifyAll();
    }

    public synchronized String consume() throws InterruptedException {
        while (orders.isEmpty()) {
            wait();
        }
        String order = orders.poll();
        System.out.println("  [CONSUMED] " + order + " | Depth: " + orders.size());
        notifyAll();
        return order;
    }
}
/**
 * Thread-Safety Verification & Optimization
 * Target Module: OrderBook.java
 */

public class OrderProducer implements Runnable {
    private final OrderBook orderBook;

    public OrderProducer(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                orderBook.produce("LIMIT_BUY_100_@$" + (150 + i));
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
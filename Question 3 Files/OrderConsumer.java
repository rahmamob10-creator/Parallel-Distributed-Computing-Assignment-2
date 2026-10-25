public class OrderConsumer implements Runnable {
    private final OrderBook orderBook;

    public OrderConsumer(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                orderBook.consume();
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
public class HFTOrderBookApp {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- High-Frequency Order Book Processing ---");
        OrderBook book = new OrderBook(3);cd ..



        Thread producerThread = new Thread(new OrderProducer(book), "ProducerThread");
        Thread consumerThread = new Thread(new OrderConsumer(book), "ConsumerThread");

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
        System.out.println("Order Book Processing Complete.");
    }
}
/**
 * Thread-Safety Verification & Optimization
 * Target Module: HFTOrderBookApp.java
 */

// Execution Log Verification Updated

public class TradingEngineApp {
    public static void main(String[] args) {
        System.out.println("--- Dynamic Method Overriding & Polymorphic Dispatch ---");
        
        TradeEvent fixOrder = new FIXOrderEvent("FIX_GATEWAY_01", System.currentTimeMillis(), 1200.50, "ORD-8841");
        TradeEvent reutersQuote = new ReutersQuoteEvent("REUTERS_GATEWAY_02", System.currentTimeMillis(), 1200.50, 1200.10, 1200.80);

        fixOrder.dispatch();
        reutersQuote.dispatch();
    }
}

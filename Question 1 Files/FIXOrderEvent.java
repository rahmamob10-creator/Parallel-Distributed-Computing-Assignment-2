public class FIXOrderEvent extends TradeEvent {
    private String clOrdId;

    public FIXOrderEvent(String senderId, long timestamp, double basePrice, String clOrdId) {
        super(senderId, timestamp, basePrice);
        this.clOrdId = clOrdId;
    }

    @Override
    public void dispatch() {
        double exchangeFee = basePrice * 0.0015;
        double totalCost = basePrice + exchangeFee;
        System.out.println("[FIX Order] OrderID: " + clOrdId + " | Sender: " + senderId + 
                           " | Base: $" + basePrice + " | Fee (0.15%): $" + exchangeFee + " | Total: $" + totalCost);
    }
}
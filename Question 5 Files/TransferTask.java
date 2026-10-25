public class TransferTask implements Runnable {
    private final BankAccount fromAcc;
    private final BankAccount toAcc;
    private final double amount;

    public TransferTask(BankAccount fromAcc, BankAccount toAcc, double amount) {
        this.fromAcc = fromAcc;
        this.toAcc = toAcc;
        this.amount = amount;
    }

    @Override
    public void run() {
        // Enforce deterministic lock ordering using string lexicographical comparison
        BankAccount firstLock = fromAcc.getAccountId().compareTo(toAcc.getAccountId()) < 0 ? fromAcc : toAcc;
        BankAccount secondLock = firstLock == fromAcc ? toAcc : fromAcc;

        firstLock.getLock().lock();
        secondLock.getLock().lock();
        try {
            if (fromAcc.getBalance() >= amount) {
                fromAcc.withdraw(amount);
                toAcc.deposit(amount);
                System.out.println("[SUCCESS] Transferred $" + amount + " from " + 
                                   fromAcc.getAccountId() + " to " + toAcc.getAccountId());
            } else {
                System.out.println("[FAILED] Insufficient funds in " + fromAcc.getAccountId());
            }
        } finally {
            secondLock.getLock().unlock();
            firstLock.getLock().unlock();
        }
    }
}
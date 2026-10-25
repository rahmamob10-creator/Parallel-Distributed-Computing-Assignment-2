public class ConcurrentLedgerApp {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Deadlock-Free Ledger Transfer Simulation ---");

        BankAccount accA = new BankAccount("ACC_001", 1000.00);
        BankAccount accB = new BankAccount("ACC_002", 1500.00);

        Thread t1 = new Thread(new TransferTask(accA, accB, 200.00));
        Thread t2 = new Thread(new TransferTask(accB, accA, 500.00));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Balance " + accA.getAccountId() + ": $" + accA.getBalance());
        System.out.println("Final Balance " + accB.getAccountId() + ": $" + accB.getBalance());
    }
}
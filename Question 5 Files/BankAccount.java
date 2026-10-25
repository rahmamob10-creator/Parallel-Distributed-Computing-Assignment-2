import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private final String accountId;
    private double balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() { return accountId; }
    public double getBalance() { return balance; }
    public Lock getLock() { return lock; }

    public void withdraw(double amount) { balance -= amount; }
    public void deposit(double amount) { balance += amount; }
}
/**
 * Thread-Safety Verification & Optimization
 * Target Module: BankAccount.java
 */

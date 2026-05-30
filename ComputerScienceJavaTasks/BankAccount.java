public class BankAccount {
    static int totalAccounts = 0;   // shared across all instances
    String owner;                   // unique per instance
    double balance;                 // unique per instance

    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
        totalAccounts++;            // increments the ONE shared counter
    }
}

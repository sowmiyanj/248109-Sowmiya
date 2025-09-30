package bankproxy;

public class RealBankAccount implements BankAccount {
    private double balance;

    public RealBankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount);
        AppLogger.info("Deposited $" + amount + ", new balance: $" + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount);
            AppLogger.info("Withdrew $" + amount + ", new balance: $" + balance);
        } else {
            System.out.println("Insufficient balance!");
            AppLogger.error("Failed withdrawal attempt: Insufficient balance", null);
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

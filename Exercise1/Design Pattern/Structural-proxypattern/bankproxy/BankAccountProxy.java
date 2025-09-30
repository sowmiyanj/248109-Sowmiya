package bankproxy;

public class BankAccountProxy implements BankAccount {
    private final RealBankAccount realAccount;
    private final String password;

    public BankAccountProxy(double initialBalance, String password) {
        this.realAccount = new RealBankAccount(initialBalance);
        this.password = password;
    }

    private boolean authenticate(String inputPassword) {
        if (!password.equals(inputPassword)) {
            System.out.println("Authentication failed!");
            AppLogger.error("Authentication failed.", null);
            return false;
        }
        return true;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive!");
            AppLogger.error("Invalid deposit amount: " + amount, null);
            return;
        }
        realAccount.deposit(amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive!");
            AppLogger.error("Invalid withdrawal amount: " + amount, null);
            return;
        }
        String input = RetryUtils.retryInput("Enter password to withdraw: ", p -> p, 3);
        if (authenticate(input)) {
            realAccount.withdraw(amount);
        } else {
            System.out.println("Cannot withdraw, authentication failed.");
        }
    }

    @Override
    public double getBalance() {
        return realAccount.getBalance();
    }
}

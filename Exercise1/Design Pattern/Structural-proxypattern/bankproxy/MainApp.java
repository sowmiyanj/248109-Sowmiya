package bankproxy;

public class MainApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccountProxy(1000, "1234"); // initial balance & password
        int choice;

        do {
            System.out.println("\n==== Bank Account Menu ====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            choice = RetryUtils.retryInput("Enter choice: ", Integer::parseInt, 3);

            switch (choice) {
                case 1 -> {
                    double amount = RetryUtils.retryInput("Enter deposit amount: $", Double::parseDouble, 3);
                    account.deposit(amount);
                }
                case 2 -> {
                    double amount = RetryUtils.retryInput("Enter withdrawal amount: $", Double::parseDouble, 3);
                    account.withdraw(amount);
                }
                case 3 -> System.out.println("Current balance: $" + account.getBalance());
                case 4 -> System.out.println("Exiting Bank Account system...");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 4);
    }
}

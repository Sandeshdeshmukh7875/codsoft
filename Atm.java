public class ATM {

    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void runATM() {
        while (true) {
            displayMenu();
            int choice = Integer.parseInt(System.in.nextLine());

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you for using our services!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private void withdraw() {
        double amount = 0;
        do {
            System.out.println("Enter the amount to withdraw: ");
            amount = Double.parseDouble(System.in.nextLine());
        } while (!isValidWithdrawalAmount(amount));

        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. Remaining balance: $" + userAccount.getBalance());
        } else {
            System.out.println("Withdrawal failed. Insufficient funds or invalid amount.");
        }
    }

    private void deposit() {
        double amount = 0;
        do {
            System.out.println("Enter the amount to deposit: ");
            amount = Double.parseDouble(System.in.nextLine());
        } while (!isValidDepositAmount(amount));

        if (userAccount.deposit(amount)) {
            System.out.println("Deposit successful. New balance: $" + userAccount.getBalance());
        } else {
            System.out.println("Deposit failed. Invalid amount.");
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + userAccount.getBalance());
    }

    private boolean isValidWithdrawalAmount(double amount) {
        return amount > 0 && amount <= userAccount.getBalance();
    }

    private boolean isValidDepositAmount(double amount) {
        return amount > 0;
    }
}
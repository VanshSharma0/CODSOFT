import java.util.Scanner;

public class ATM { 

    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void Withdrawal(double amount) { 
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Your remaining balance is: Rupees " + account.getBalance());
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public void Deposit(double amount) {
        account.deposit(amount);
        System.out.println("Deposit successful. Your new balance is: Rupees " + account.getBalance());
    }

    public void display() {
        System.out.println("Your current balance is: Rupees " + account.getBalance());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(1000.0);

        ATM atm = new ATM(account);

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.display();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: Rupees ");
                    double depositAmount = scanner.nextDouble();
                    atm.Deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: Rupees ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.Withdrawal(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

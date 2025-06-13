import java.util.Scanner;
import java.util.ArrayList;
public class App {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        //SHOWING THE MENU
        System.out.println("---Welcome to the Bank Account Simulator!---");
        int option;
        do{
            showMenu();
            option = sc.nextInt();
            switch(option){
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    amountConsult();
                    break;
                case 6:
                    viewAccounts();
                    break;
                case 0:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }while(option != 0);
        sc.close();
    }
    // Method to display the menu
    public static void showMenu() {
        System.out.println("\n--- Bank Simulator ---");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Check Balance");
        System.out.println("6. List All Accounts");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }
    // Method to create a new account
    public static void createAccount(){
        System.out.println("Enter account number:");
        String accountNumber = sc.next();
        System.out.println("Enter account holder name:");
        String accountHolder = sc.next();
        System.out.println("Enter initial balance:");
        double initialBalance = sc.nextDouble();
        // Check if account already exists
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                System.out.println("Account with this number already exists.");
                return;
            }
        }
        // Create a new account
        BankAccount newAccount = new BankAccount(accountNumber, accountHolder, initialBalance);
        accounts.add(newAccount);
        // Display success message
        System.out.println("Account created successfully.");
    }
    // Method to find an account by its number
    public static BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null; // Account not found
    }
    // Methods for deposit, withdrawal, balance inquiry, and transfer
    public static void deposit(){
        System.out.println("Enter account number for deposit:");
        String accountNumber = sc.next();
        System.out.println("Enter amount to deposit:");

        BankAccount account = findAccount(accountNumber);

        if(account != null) {
            double amount = sc.nextDouble();
            if (amount > 0) {
                account.deposit(amount);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }
    public static void withdraw(){
        System.out.println("Enter account number for withdrawal:");
        String accountNumber = sc.next();
        System.out.println("Enter amount to withdraw:");

        BankAccount account = findAccount(accountNumber);

        if(account != null) {
            double amount = sc.nextDouble();
            if (amount > 0) {
                account.withdraw(amount);
            } else {
                System.out.println("Invalid withdrawal amount.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void transfer() {
        System.out.println("Enter the account number to transfer from:");
        String fromAccountNumber = sc.next();
        BankAccount fromAccount = findAccount(fromAccountNumber);
        if (fromAccount == null) {
            System.out.println("From account not found.");
            return;
        }
        System.out.println("Enter the account number to transfer to:");
        String toAccountNumber = sc.next();
        BankAccount toAccount = findAccount(toAccountNumber);
        if (toAccount == null) {
            System.out.println("To account not found.");
            return;
        }
        System.out.println("Enter the amount to transfer:");
        double amount = sc.nextDouble();
        if (amount > 0 && fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Invalid transfer amount.");
        }
    }

    public static void amountConsult(){
        System.out.println("Enter account number for balance inquiry:");
        String accountNumber = sc.next();

        BankAccount account = findAccount(accountNumber);

        if(account != null) {
            System.out.println("Account Balance: R$" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
    public static void viewAccounts(){
        System.out.println("\n--- Account List ---");
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
        } else {
            for (BankAccount account : accounts) {
                System.out.println("Account Number: " + account.getAccountNumber() +
                                   ", Account Holder: " + account.getAccountHolderName() +
                                   ", Balance: R$" + account.getBalance());
            }
        }
    }
    


}

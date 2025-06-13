public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private Double balance;

    public BankAccount(String accountNumber, String accountHolderName, Double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        System.out.println("Account " + accountNumber + " created for " + accountHolderName + " with initial balance of R$" + initialBalance + ".");
    }
    public void deposit(Double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposit of R$" + amount + " made to account " + accountNumber + ". Current balance: R$" + balance + ".");
        } else {
            System.out.println("Invalid deposit amount.");
        }

    }
    public void withdraw(Double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            System.out.println("Withdrawal of R$" + amount + " made from account " + accountNumber + ". Current balance: R$" + balance + ".");
        } else if (amount > balance) {
            System.out.println("Insufficient funds for withdrawal of R$" + amount + ".");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public Double getBalance() {
        return balance;
    }
}
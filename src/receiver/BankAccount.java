package receiver;

public class BankAccount {
    private final String number;
    private final String owner;
    private double balance;

    public BankAccount(String number, String owner, double initialBalance) {
        this.number = number;
        this.owner = owner;
        this.balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) return false;
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) return false;
        balance -= amount;
        return true;
    }

    public boolean transfer(BankAccount destination, double amount) {
        if (withdraw(amount)) {
            destination.deposit(amount);
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return balance;
    }

    public String getNumber() { return number; }
    public String getOwner() { return owner; }

    @Override
    public String toString() {
        return owner + " (" + number + ")";
    }
}
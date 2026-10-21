package command;

import receiver.BankAccount;

public class DepositCommand implements Command {
    private final BankAccount account;
    private final double amount;
    private boolean executed = false;

    public DepositCommand(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        executed = account.deposit(amount);
        System.out.println(executed
                ? "Deposit of $" + amount + " into " + account + " successful."
                : "Deposit rejected for " + account + " (invalid amount).");
    }

    @Override
    public void undo() {
        if (executed) {
            account.withdraw(amount);
            executed = false;
            System.out.println("Deposit of $" + amount + " reverted for " + account + ".");
        }
    }
}
package command;

import receiver.BankAccount;

public class WithdrawCommand implements Command {
    private final BankAccount account;
    private final double amount;
    private boolean executed = false;

    public WithdrawCommand(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        executed = account.withdraw(amount);
        System.out.println(executed
                ? "Withdrawal of $" + amount + " from " + account + " successful."
                : "Withdrawal rejected for " + account + " (insufficient funds or invalid amount).");
    }

    @Override
    public void undo() {
        if (executed) {
            account.deposit(amount);
            executed = false;
            System.out.println("Withdrawal of $" + amount + " reverted for " + account + ".");
        }
    }
}
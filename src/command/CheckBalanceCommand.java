package command;

import receiver.BankAccount;

public class CheckBalanceCommand implements Command {
    private final BankAccount account;

    public CheckBalanceCommand(BankAccount account) {
        this.account = account;
    }

    @Override
    public void execute() {
        System.out.println("Balance of " + account + ": $" + account.checkBalance());
    }

    @Override
    public void undo() {
    }
}
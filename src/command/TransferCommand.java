package command;

import receiver.BankAccount;

public class TransferCommand implements Command {
    private final BankAccount source;
    private final BankAccount destination;
    private final double amount;
    private boolean executed = false;

    public TransferCommand(BankAccount source, BankAccount destination, double amount) {
        this.source = source;
        this.destination = destination;
        this.amount = amount;
    }

    @Override
    public void execute() {
        executed = source.transfer(destination, amount);
        System.out.println(executed
                ? "Transfer of $" + amount + " from " + source + " to " + destination + " successful."
                : "Transfer rejected from " + source + " to " + destination + ".");
    }

    @Override
    public void undo() {
        if (executed) {
            destination.withdraw(amount);
            source.deposit(amount);
            executed = false;
            System.out.println("Transfer of $" + amount + " reverted between " + source + " and " + destination + ".");
        }
    }
}
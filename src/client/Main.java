package client;


import invoker.ATM;
import receiver.BankAccount;
import command.TransferCommand;
import command.WithdrawCommand;
import command.CheckBalanceCommand;
import command.DepositCommand;

public class Main {
    public static void main(String[] args) {
        BankAccount accountA = new BankAccount("001", "Ana", 500000);
        BankAccount accountB = new BankAccount("002", "Luis", 200000);

        ATM atm = new ATM();

        atm.executeCommands(
                new CheckBalanceCommand(accountA),
                new DepositCommand(accountA, 100000),
                new WithdrawCommand(accountA, 50000),
                new TransferCommand(accountA, accountB, 150000),
                new CheckBalanceCommand(accountA),
                new CheckBalanceCommand(accountB)
        );

        atm.executeCommand(new WithdrawCommand(accountB, 9999999));

        System.out.println("\n--- Undoing operations ---");
        atm.undoLast();
        atm.undoLast();
        atm.undoLast(); 
        atm.undoLast(); 
        new CheckBalanceCommand(accountA).execute();
        new CheckBalanceCommand(accountB).execute();
    }
}
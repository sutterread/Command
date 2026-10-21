package invoker;

import command.Command;
import java.util.Stack;

public class ATM {
    private final Stack<Command> history = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void executeCommands(Command... commands) {
        for (Command c : commands) {
            executeCommand(c);
        }
    }

    public void undoLast() {
        if (history.isEmpty()) {
            System.out.println("No operations to undo.");
            return;
        }
        history.pop().undo();
    }
}
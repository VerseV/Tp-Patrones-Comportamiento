package Main.Java.Command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private List<Command> history = new ArrayList<>();

    public void executeCommand(Command command) {
        history.add(command);
        command.execute();
    }

    public void showHistory() {
        System.out.println("\nHistorial de comandos ejecutados: " + history.size());
        for (int i = 0; i < history.size(); i++) {
            System.out.println("Comando " + (i+1) + " ejecutado.");
        }
    }
}


package commandserver;

import java.io.PrintWriter;

public class CommandSRC implements Command {
    @Override
    public void execute(PrintWriter writer) {
        System.out.println("Hello");
    }
}

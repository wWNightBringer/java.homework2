package commandserver;

import java.io.PrintWriter;

public class CommandHello implements Command {

    @Override
    public void execute(PrintWriter writer) {
        writer.write("Hello");
        writer.write("\n");
        writer.flush();
    }
}

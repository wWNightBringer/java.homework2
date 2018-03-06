package commandserver;

import java.io.PrintWriter;

public interface Command {
    void execute(PrintWriter writer);
}

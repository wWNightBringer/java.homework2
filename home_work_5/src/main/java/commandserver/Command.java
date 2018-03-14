package commandserver;

import java.io.IOException;
import java.io.PrintWriter;

public interface Command {
    void execute(PrintWriter writer) throws IOException, IllegalAccessException;
}

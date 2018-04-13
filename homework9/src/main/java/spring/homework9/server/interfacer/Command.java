package spring.homework9.server.interfacer;

import java.io.PrintWriter;

public interface Command {
    void execute(PrintWriter writer);
}

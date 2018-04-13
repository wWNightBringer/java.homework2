package spring.homework9.server;

import spring.homework9.server.interfacer.Command;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Datetime implements Command {
    @Override
    public void execute(PrintWriter writer) {
        writer.format("Current date and time is %s %n", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }
}

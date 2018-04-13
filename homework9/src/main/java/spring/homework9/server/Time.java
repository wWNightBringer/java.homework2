package spring.homework9.server;

import spring.homework9.server.interfacer.Command;

import java.io.PrintWriter;
import java.time.LocalTime;

public class Time implements Command {
    @Override
    public void execute(PrintWriter writer) {
        writer.format("Current time %s %n",LocalTime.now().getHour());
    }
}

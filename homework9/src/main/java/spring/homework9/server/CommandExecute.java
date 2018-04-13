package spring.homework9.server;

import spring.homework9.server.interfacer.Command;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CommandExecute implements Runnable {
    private final Socket socket;
    private CommandParser commandParser;

    public CommandExecute(Socket socket) {
        this.socket = socket;
        this.commandParser = new CommandParser();
    }

    @Override
    public void run() {
        try (Socket s = socket) {
            Scanner scanner = new Scanner(s.getInputStream());
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
            while (true) {
                if (scanner.hasNext()) {
                    String commandLine = scanner.nextLine().trim();
                    System.out.println(commandLine);
                    if ("exit".equalsIgnoreCase(commandLine)) {
                        break;
                    }
                    try {
                        Command command = commandParser.parseCommand(commandLine);
                        command.execute(printWriter);
                    } catch (Exception e) {
                        printWriter.format("Unknown command %s", commandLine);
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}

package commandserver;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Executor implements Runnable {
    private final CommandMaper commandMap;
    private final Socket socket;
    private final String CHARSET="UTF-8";
    public Executor(Socket socket) {
        this.socket = socket;
        this.commandMap = new CommandMaper();
    }

    @Override
    public void run() {
        try (Socket s = socket) {
            Scanner scanner = new Scanner(s.getInputStream(),CHARSET);
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(s.getOutputStream(),CHARSET), true);
            while (true) {
                if (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    System.out.println(line);

                    if ("exit".equalsIgnoreCase(line)) {
                        break;
                    }
                    try {
                        Command command = commandMap.parse(line);
                        command.execute(writer);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

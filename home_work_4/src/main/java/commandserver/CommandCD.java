package commandserver;

import java.io.File;
import java.io.PrintWriter;

public class CommandCD implements Command {
    private final String line;
    private File file;

    public CommandCD(String line) {
        this.line = line;
    }

    @Override
    public void execute(PrintWriter writer) {
        String[] strings = line.split(" ");
        file = new File(strings[1]);
        for (File f : file.listFiles()) {
            writer.append(f.getName());
            writer.write("\n");
        }


        writer.flush();
    }
}

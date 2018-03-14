package commandserver;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class CommandCD implements Command {
    private String line;
    private File file;
    private Path path;

    public CommandCD(String line) {
        this.line = line;
    }

    @Override
    public void execute(PrintWriter writer) throws IllegalAccessException {
        List<String> list = new ArrayList<>();
        list.add(line);
        path = Paths.get(System.getProperty("user.dir"));
        if (list.size() != 0) {
            for (String s : list) {
                    if (s.equalsIgnoreCase("..")) {
                        file = new File(String.valueOf(path.getParent()));
                        writer.write(file.getAbsolutePath());
                        writer.write("\n");
                    }
                    if (s.equalsIgnoreCase("/")) {
                        file = new File(String.valueOf(path.getRoot()));
                        writer.write(file.getAbsolutePath());
                        writer.write("\n");
                }
            }

        } else {
            writer.write("Error");
            throw new IllegalAccessException();
        }
        writer.flush();
    }
}

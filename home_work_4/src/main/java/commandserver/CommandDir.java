package commandserver;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class CommandDir implements Command {
    private File file;

    public void execute(PrintWriter writer) throws IOException {
        Path path = Paths.get(System.getProperty("user.dir"));
        file = new File(String.valueOf(path.toFile()));
        if (file.exists()) {
            writer.write("Directory of " + file.getAbsolutePath());
            for (File f : file.listFiles()) {
                writer.append(f.getName());
                writer.println("\n");

            }


        }
        writer.flush();
    }


}

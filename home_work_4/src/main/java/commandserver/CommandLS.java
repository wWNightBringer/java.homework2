package commandserver;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Path;

public class CommandLS implements Command {
    private File file;

    public void execute(PrintWriter writer) {
        file = new File("C:\\Users\\Nightbringer\\IdeaProjects\\HomeWork2\\home_work_4\\src\\main\\java\\commandserver");
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                if (f.isDirectory()) {
                    writer.append(f.getName());
                    writer.println("\n");
                } else {
                    writer.append(f.getName());
                    writer.println("\n");
                }

            }


        }
        writer.flush();
    }


}

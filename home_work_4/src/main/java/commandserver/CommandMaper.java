package commandserver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CommandMaper {
    private final Map<String, Supplier<Command>> map;

    public CommandMaper() {
        this.map = new HashMap<>();
        map.put("src", () -> new CommandSRC());
        map.put("dir", () -> new CommandDir());
    }

    public Command parse(String line) throws IllegalAccessException {
        Supplier<Command> supplier = map.get(line.toLowerCase());
        if (supplier == null) {
            throw new IllegalAccessException(line);
        }
        return supplier.get();
    }
}

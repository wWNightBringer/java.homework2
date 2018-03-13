package commandserver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CommandMaper {
    private final Map<String, Supplier<Command>> map;

    public CommandMaper() {
        this.map = new HashMap<>();
    }

    public Command parse(String line) throws IllegalAccessException {
        String[] strings = line.split(" ");
        map.put("cd", () -> new CommandCD(strings[1]));
        map.put("dir", () -> new CommandDir());
        map.put("hello", () -> new CommandHello());
        Supplier<Command> supplier = map.get(strings[0]);
        if (supplier == null) {
            throw new IllegalAccessException(line);
        }
        return supplier.get();
    }
}

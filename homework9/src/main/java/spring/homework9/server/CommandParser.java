package spring.homework9.server;

import spring.homework9.server.interfacer.Command;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CommandParser {
    private Map<String, Supplier<Command>> supplierMap;

    public CommandParser() {
        supplierMap = new HashMap<>();
        supplierMap.put("time", () -> new Time());
        supplierMap.put("datetime", () -> new Datetime());
    }

    public Command parseCommand(String commandLine) {
        Supplier<Command> supplier = supplierMap.get(commandLine);
        if (supplier == null) {
            throw new IllegalAccessError();
        }
        return supplier.get();
    }
}

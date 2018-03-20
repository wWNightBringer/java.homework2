package commandserver;

import java.io.IOException;
import java.io.PrintWriter;

public interface Command {
    /**
    Этот метод должен принимать кроме PrintWriter еще и список аргументов, к примеру String ... args
    либо массив что впринципе одно и тоже
    Тогда команды можно создать один раз в конструкторе CommandMaper'a и не каждый раз во время парсинга
    **/ 
    void execute(PrintWriter writer) throws IOException, IllegalAccessException;
}

package commandserver;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class MyMain {
    public static void main(String[] args) {
        Server server = new Server(8080);
        server.start();
    }
}

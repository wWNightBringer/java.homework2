package commandserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Server {
    private int port;
    private static ThreadPoolExecutor poolExecutor;
    private static Lock lock;

    public Server(int port) {
        poolExecutor = new ThreadPoolExecutor(1, 100, 10, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(1000));
        this.port = port;
    }

    public void start() {

        Socket socket;
        System.out.println("Server started");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                System.out.println("New client in queue " + port);
                socket = serverSocket.accept();
                System.out.println("Client was connected " + socket.isConnected());
                poolExecutor.execute(new Executor(socket));
                try {
                    poolExecutor.awaitTermination(3, TimeUnit.MINUTES);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

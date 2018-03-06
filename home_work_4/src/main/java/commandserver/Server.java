package commandserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final int port;

    public Server(int port) {
        this.port = port;
    }

    public void start(int max) {
        System.out.println("Server started");
        try (ServerSocket serverSocket = new ServerSocket(port, max)) {
            while (true) {
                System.out.println("New client in queue "+port);
                Socket socket=serverSocket.accept();
                System.out.println("Client was connected "+socket.isConnected());
                Thread thread=new Thread(new Executor(socket));
                thread.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        Server server=new Server(8080);
        server.start(100);
    }
}

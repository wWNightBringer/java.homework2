package spring.homework9.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import spring.homework9.server.interfacer.ServerRepository;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class Server implements ServerRepository {
    private final Executor poolExecutor;
    private String messageAccept;
    private String messageError;

    @Autowired
    public Server(Executor poolExecutor) {
        this.poolExecutor = poolExecutor;
    }

    @Override
    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                System.out.println("Localhost" + serverSocket.getLocalPort());
                Socket socket = serverSocket.accept();
                System.out.println(getMessage() + socket.isConnected());
                poolExecutor.execute(new CommandExecute(socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Value("${server.message.accept")
    public void setMessageAccept(String msg) {
        this.messageAccept = msg;
    }

    public String getMessage() {
        return messageAccept;
    }

    public String getMessageError() {
        return messageError;
    }

    @Value("${server.message.error}")
    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }
}

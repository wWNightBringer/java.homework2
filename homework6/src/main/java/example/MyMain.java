package example;

import example.action.MyAction;

import java.io.IOException;
import java.sql.SQLException;

public class MyMain {
    private static MyAction action;
    private static Connect connect;

    public static void main(String[] args) throws SQLException, IOException {
        action = new MyAction();
        connect = new Connect();
        action.choose(connect.connectionToDatabase());
    }
}

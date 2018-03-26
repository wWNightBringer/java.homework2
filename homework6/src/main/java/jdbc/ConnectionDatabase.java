package jdbc;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {
    private String url;
    private String login;
    private String password;

    public ConnectionDatabase() {
        this.url="jdbc:mysql://localhost:3306/test";
        this.login="root";
        this.password="root";
    }

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,login,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

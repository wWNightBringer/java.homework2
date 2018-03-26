package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    private final String URL = "jdbc:mysql://localhost:3306";
    private final String LOGIN = "root";
    private final String PASSWORD = "root";
    public Connect() {

    }
    public Connection connectionToDatabase() {
        Connection connection = null;
        try {
            connection= DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

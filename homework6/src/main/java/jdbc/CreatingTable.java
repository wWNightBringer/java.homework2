package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatingTable {
    public void createTable(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(QueryHolder.getHOLDER().getQuery("table.client"));
            statement.execute(QueryHolder.getHOLDER().getQuery("table.phone"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

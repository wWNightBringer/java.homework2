package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTable {
    public void insert(Connection connection, int id, String name, String lastname, String address, int inn) {
        try (PreparedStatement statement = connection.prepareStatement(QueryHolder.getHOLDER().getQuery("insert.client"))) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, lastname);
            statement.setString(4, address);
            statement.setInt(5, inn);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        {

        }
    }
}

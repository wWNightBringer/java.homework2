package database.interfaces;

import java.sql.Connection;

public interface JdbcRepository {
    void connect(Connection connection);
}

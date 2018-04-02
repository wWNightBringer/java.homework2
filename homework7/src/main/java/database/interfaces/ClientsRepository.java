package database.interfaces;

import java.sql.Connection;

public interface ClientsRepository {
    void connect(Connection connection);
}

package example.iinterface;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseAction {
    void actionActivityDatabase(Connection connection) throws SQLException, IOException;
}

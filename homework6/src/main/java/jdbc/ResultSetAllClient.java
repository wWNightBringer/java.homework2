package jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetAllClient {
    private static CreatingTable creatingTable;
    private static ConnectionDatabase connectionDatabase;
    private static InsertTable insertTable;

    public ResultSetAllClient() {
        creatingTable = new CreatingTable();
        connectionDatabase = new ConnectionDatabase();
        insertTable = new InsertTable();
        creatingTable.createTable(connectionDatabase.connect());
        insertTable.insert(connectionDatabase.connect(), 1, "Andrew", "Jackson", "Street", 12345);
        insertTable.insert(connectionDatabase.connect(), 2, "Jack", "Jackson1", "StreetAvenue", 78545);
        insertTable.insert(connectionDatabase.connect(), 3, "John", "Jackson2", "StreetBow", 963225);
        insertTable.insert(connectionDatabase.connect(), 4, "Kate", "Jackson3", "StreetBones", 47851);
        insertTable.insert(connectionDatabase.connect(), 5, "Kianu", "Jackson4", "StreetHead", 74125);
    }

    public void showAllClient() throws SQLException {
        PreparedStatement statement = connectionDatabase.connect().prepareStatement(QueryHolder.getHOLDER().getQuery("select.client"));
        statement.setInt(1, 1);
        try (ResultSet set = statement.executeQuery()) {
            while (set.next()) {
                System.out.println(set.getInt(1));
                System.out.println(set.getString("name"));
                System.out.println(set.getInt(3));
                System.out.println(set.getString("address"));
                System.out.println(set.getInt(5));
            }
        }
    }
}

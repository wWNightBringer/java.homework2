package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import database.interfaces.ClientsRepository;
import model.ClientsRecord;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadingClients implements ClientsRepository {
    private ObservableList<ClientsRecord> observableList;
    private ResultSet resultSet;

    public ReadingClients() {
        observableList = FXCollections.observableArrayList();
    }

    @Override
    public void connect(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery("SELECT * FROM test.person,test.phone WHERE person.ID=phone.PersonID GROUP BY person.ID");
            while (resultSet.next()) {
                observableList.add(new ClientsRecord(resultSet.getInt(1), resultSet.getString("Name"),
                        resultSet.getString("Address"), resultSet.getInt(4), resultSet.getString("Nick")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<ClientsRecord> getObservableList() {
        return observableList;
    }
}

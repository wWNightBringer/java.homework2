package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InMemoryJdbcRepository implements JdbcRecordRepository {
    private ObservableList<JdbcRecord> observableList;
    public InMemoryJdbcRepository() {
        observableList= FXCollections.observableArrayList();
        observableList.add(new JdbcRecord(1,"Andrew","asd1",21324,"Jack"));
        observableList.add(new JdbcRecord(1,"Andrew1","asd2",123,"Jack"));
    }

    @Override
    public ObservableList<JdbcRecord> getAllPhone() {
        return null;
    }

    @Override
    public void insert(JdbcRecord phoneRecord) {
        observableList.add(phoneRecord);
    }

    @Override
    public void delete(JdbcRecord phoneRecord) {
        observableList.remove(phoneRecord);
    }
}

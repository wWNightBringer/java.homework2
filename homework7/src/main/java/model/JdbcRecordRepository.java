package model;

import javafx.collections.ObservableList;

public interface JdbcRecordRepository {
    ObservableList<JdbcRecord> getAllPhone();
    void insert(JdbcRecord phoneRecord);
    void delete(JdbcRecord phoneRecord);
}

package model;

import javafx.collections.ObservableList;

public interface ClientsRecordRepository {
    ObservableList<ClientsRecord> getAllPhone();
    void insert(ClientsRecord phoneRecord);
    void delete(ClientsRecord phoneRecord);
}

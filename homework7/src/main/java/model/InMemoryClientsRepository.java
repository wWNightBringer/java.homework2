package model;

import javafx.collections.ObservableList;

public class InMemoryClientsRepository implements ClientsRecordRepository {
    private ObservableList<ClientsRecord> observableList;

    public InMemoryClientsRepository() {
    }

    @Override
    public ObservableList<ClientsRecord> getAllPhone() {
        return null;
    }

    @Override
    public void insert(ClientsRecord phoneRecord) {
        observableList.add(phoneRecord);
    }

    @Override
    public void delete(ClientsRecord phoneRecord) {
        observableList.remove(phoneRecord);
    }
}

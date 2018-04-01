package controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.ClientsRecord;
import validator.EngineValidator;

import java.awt.*;

public class EditController {
    private Stage stage;
    private ClientsRecord record;
    private EngineValidator validator;
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField address;
    @FXML
    private TextField phone;
    @FXML
    private TextField nick;

    public EditController() {
        validator = new EngineValidator();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setRecord(ClientsRecord record) {
        this.record = record;
        id.setText(String.valueOf(record.getId()));
        name.setText(record.getName());
        address.setText(record.getAddress());
        phone.setText(String.valueOf(record.getPhone()));
        nick.setText(record.getNick());
    }

    public Stage getStage() {
        return stage;
    }

    public ClientsRecord getRecord() {
        return record;
    }

    public void edit(ClientsRecord clientsRecord) {
        setRecord(clientsRecord);
        stage.showAndWait();
    }

    @FXML
    public void hadleOk() throws IllegalAccessException {
        if (validate()) {
            record.setId(Integer.parseInt(id.getText()));
            record.setName(name.getText());
            record.setAddress(address.getText());
            record.setPhone(Integer.valueOf(phone.getText()));
            record.setNick(nick.getText());
        }
    }

    private boolean validate() throws IllegalAccessException {
        return validator.validater(record);
    }

    @FXML
    public void handleCancel() {
        stage.hide();
    }

}

package controller;

import database.Connect;
import database.interfaces.ClientsRepository;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ClientsRecord;
import validator.Correct;
import validator.EngineValidator;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EditController implements ClientsRepository {
    private Connect connect;
    private Stage editStage;
    private ClientsRecord record;
    private Correct validator;
    @FXML
    private TextField idEdit;
    @FXML
    private TextField nameEdit;
    @FXML
    private TextField addressEdit;
    @FXML
    private TextField phoneEdit;
    @FXML
    private TextField nickEdit;

    public void setEditStage(Stage editStage) {
        this.editStage = editStage;
    }

    public EditController() {
        validator = new Correct();
        connect=new Connect();
    }

    public void setRecord(ClientsRecord record) {
        this.record = record;
        idEdit.setText(String.valueOf(record.getId()));
        nameEdit.setText(record.getName());
        addressEdit.setText(record.getAddress());
        phoneEdit.setText(String.valueOf(record.getPhone()));
        nickEdit.setText(record.getNick());
        editStage.showAndWait();
    }

    public ClientsRecord getRecord() {
        return record;
    }

    @FXML
    public void handleOk() throws IllegalAccessException {
        if (validate()==5) {
            record.setId(Integer.parseInt(idEdit.getText()));
            record.setName(nameEdit.getText());
            record.setAddress(addressEdit.getText());
            record.setPhone(Integer.parseInt(phoneEdit.getText()));
            record.setNick(nickEdit.getText());
            connect(connect.connectionToDatabase());
        }else{
            System.out.println(1);
        }
    }

    private int validate() throws IllegalAccessException {
        return validator.validator(record);
    }

    @FXML
    public void handleCancel() {
        editStage.hide();
    }

    @Override
    public void connect(Connection connection) {
        try(Statement statement=connection.createStatement()) {
            statement.execute("INSERT INTO person (ID,NAME,ADDRESS,phone) VALUES (" + idEdit + ",'" + nameEdit + "','" + addressEdit + "','" +
                    phoneEdit +",'" + nickEdit + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(ClientsRecord clientsRecord){
        setRecord(clientsRecord);
        editStage.hide();
    }
}

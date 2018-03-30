package controller;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.JdbcRecord;
import model.JdbcRecordRepository;

import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private Stage mainStage;
    private EditController editController;
    private JdbcRecordRepository recordRepository;
    @FXML
    private TableView<JdbcRecord> tableView;
    @FXML
    private TableColumn<JdbcRecord,Integer> id;
    @FXML
    private TableColumn<JdbcRecord,String> name;
    @FXML
    private TableColumn<JdbcRecord,String> address;
    @FXML
    private TableColumn<JdbcRecord,Integer> phone;
    @FXML
    private TableColumn<JdbcRecord,String> nick;
    @FXML
    private Button insert;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private Label number;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<JdbcRecord,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        nick.setCellValueFactory(new PropertyValueFactory<>("nick"));
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public void setEditController(EditController editController) {
        this.editController = editController;
    }

    public void setRecordRepository(JdbcRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
        ObservableList<JdbcRecord> observableList=recordRepository.getAllPhone();
        number.setText(String.valueOf(observableList.size()));
        observableList.addListener(new ListChangeListener<JdbcRecord>() {
            @Override
            public void onChanged(Change<? extends JdbcRecord> c) {
                number.setText(String.valueOf(c.getList().size()));
            }
        });
    }
    @FXML
    public void insertData(){
        JdbcRecord jdbcRecord=new JdbcRecord();
        editController.edit(jdbcRecord);
        recordRepository.insert(jdbcRecord);
    }

}

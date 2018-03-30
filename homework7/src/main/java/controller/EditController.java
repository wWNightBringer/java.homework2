package controller;

import javafx.stage.Stage;
import model.JdbcRecord;

public class EditController {
    private Stage stage;
    private JdbcRecord record;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setRecord(JdbcRecord record) {
        this.record = record;
    }

    public Stage getStage() {
        return stage;
    }

    public JdbcRecord getRecord() {
        return record;
    }

    public void edit(JdbcRecord jdbcRecord) {
        stage.showAndWait();
    }
}

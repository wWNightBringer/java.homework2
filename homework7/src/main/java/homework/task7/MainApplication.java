package homework.task7;

import controller.EditController;
import controller.MainController;
import database.Connect;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import database.ReadingClients;

import java.io.IOException;

public class MainApplication extends Application {
    private Connect connect;
    private ReadingClients readingClients;
    private Stage stage;
    private MainController mainController;
    private EditController editController;

    public MainApplication() {
        readingClients = new ReadingClients();
        connect = new Connect();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        readingClients.connect(connect.connectionToDatabase());
        initMainStage();
        initEditStage();
    }

    private void initMainStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main.fxml"));
        Parent root = loader.load();
        mainController = loader.getController();
        mainController.setMainStage(stage);
        mainController.setRecordRepository(readingClients);
        Scene scene = new Scene(root, 640, 380, false);
        stage.setTitle("Inform database");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void initEditStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/edit.fxml"));
        Parent parent = loader.load();
        Stage editStage = new Stage();
        editStage.setTitle("Editor");
        editStage.initModality(Modality.WINDOW_MODAL);
        editStage.initOwner(stage);
       /* editController.setStage(editStage);*/
        Scene scene = new Scene(parent);
        editStage.setScene(scene);
        editController = loader.getController();
      /*  mainController.setEditController(editController);*/

    }


}

package junit;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;

public class LineCharts extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        String[] month={
                "January","February","March","April","May","June","July","August","September","October",
                "November","December"
        };
        Pane pane=new Pane();
        CategoryAxis axisX=new CategoryAxis();
        NumberAxis axisY=new NumberAxis();
        LineChart<String,Number> lineChart=new LineChart<String, Number>(axisX,axisY);
        lineChart.setTitle("Earn");
        XYChart.Series<String,Number> series=new XYChart.Series<>();
        series.setName("Andrew earn");
        series.getData().add(new XYChart.Data<>(month[0],100));
        series.getData().add(new XYChart.Data<>(month[1],200));
        series.getData().add(new XYChart.Data<>(month[2],300));
        series.getData().add(new XYChart.Data<>(month[3],350));
        series.getData().add(new XYChart.Data<>(month[4],400));
        series.getData().add(new XYChart.Data<>(month[5],500));
        series.getData().add(new XYChart.Data<>(month[6],530));
        series.getData().add(new XYChart.Data<>(month[7],550));
        series.getData().add(new XYChart.Data<>(month[8],600));
        series.getData().add(new XYChart.Data<>(month[9],700));
        series.getData().add(new XYChart.Data<>(month[10],1000));
        series.getData().add(new XYChart.Data<>(month[11],900));

        XYChart.Series<String,Number> series1=new XYChart.Series<>();
        series1.setName("Jack earn");
        series1.getData().add(new XYChart.Data<>(month[0],300));
        series1.getData().add(new XYChart.Data<>(month[1],500));
        series1.getData().add(new XYChart.Data<>(month[2],600));
        series1.getData().add(new XYChart.Data<>(month[3],400));
        series1.getData().add(new XYChart.Data<>(month[4],500));
        series1.getData().add(new XYChart.Data<>(month[5],700));
        series1.getData().add(new XYChart.Data<>(month[6],1000));
        series1.getData().add(new XYChart.Data<>(month[7],950));
        series1.getData().add(new XYChart.Data<>(month[8],960));
        series1.getData().add(new XYChart.Data<>(month[9],1100));
        series1.getData().add(new XYChart.Data<>(month[10],1200));
        series1.getData().add(new XYChart.Data<>(month[11],1150));

        lineChart.getData().add(series);
        lineChart.getData().add(series1);
        pane.getChildren().addAll(lineChart);
        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
        Scene scene=new Scene(pane,dimension.getWidth(),dimension.getHeight());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Chart");
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }
}

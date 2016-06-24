package ua.serg.AppJavaFX.start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("../fxml/main.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(320);
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

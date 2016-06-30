package ua.serg.AppJavaFX.start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ua.serg.AppJavaFX.controllers.MainController;
import ua.serg.AppJavaFX.interfaces.impls.CollectionAddresBook;

import java.util.Locale;
import java.util.ResourceBundle;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../fxml/main.fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("ua/serg/AppJavaFX/bundles/Locale", new Locale("en")));

        Parent fxmlMain = fxmlLoader.load();
        MainController mainController = fxmlLoader.getController();
        mainController.setMainStage(primaryStage);

        primaryStage.setTitle(fxmlLoader.getResources().getString("addressBook"));
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(320);
        primaryStage.setScene(new Scene(fxmlMain));
        primaryStage.show();

//        testData();

    }

    private void testData (){
        CollectionAddresBook addressBook = new CollectionAddresBook();
        addressBook.fillTestData();
        addressBook.print();
    }




    public static void main(String[] args) {
        launch(args);
    }


}




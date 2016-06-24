package ua.serg.AppJavaFX.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button btnAdd;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnSearch;
    @FXML
    private TextField txtFSearch;
    @FXML
    private TableView tableAddresView;
    @FXML
    private TableColumn columnTel;
    @FXML
    private TableColumn columnFio;

    public void showDialog(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent parent = FXMLLoader.load(getClass().getResource("../fxml/editForm.fxml"));
            stage.setTitle("Редактирование записи");
            stage.setMinHeight(100);
            stage.setMinWidth(400);
            stage.setResizable(false);
            stage.setScene(new Scene(parent));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

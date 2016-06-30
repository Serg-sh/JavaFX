package ua.serg.AppJavaFX.controllers;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import ua.serg.AppJavaFX.interfaces.impls.CollectionAddresBook;
import ua.serg.AppJavaFX.objects.Person;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainController {
    private CollectionAddresBook addresBookImpl = new CollectionAddresBook();
    private Stage mainStage;

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

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
    private TableColumn<Person, String> columnTel;
    @FXML
    private TableColumn<Person, String> columnFio;
    @FXML
    private Label countLabel;

    private Parent fxmlEdit;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private EditDialogController editDialogController;
    private Stage editDialogStage;








    @FXML
    private void initialize() {
        columnFio.setCellValueFactory(new PropertyValueFactory<Person, String>("fio"));
        columnTel.setCellValueFactory(new PropertyValueFactory<Person, String>("tel"));

        initLisners();
        fillData();
        initLoader();


    }

    private void fillData() {
        addresBookImpl.fillTestData();
        tableAddresView.setItems(addresBookImpl.getPersonList());
    }

    private void initLoader() {
        try {
            fxmlLoader.setLocation(getClass().getResource("..//fxml/editForm.fxml"));
            fxmlLoader.setResources(ResourceBundle.getBundle("ua/serg/AppJavaFX/bundles/Locale", new Locale("en")));
            fxmlEdit=fxmlLoader.load();
            editDialogController = fxmlLoader.getController();
        } catch (IOException e){ e.printStackTrace(); }
    }

    private void initLisners() {

        addresBookImpl.getPersonList().addListener((ListChangeListener<Person>) c -> {
            updateCountLabel();
        });

        tableAddresView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2){
                    editDialogController.setPerson((Person) tableAddresView.getSelectionModel().getSelectedItem());
                    showDialog();
                }
            }
        });
    }

    private void updateCountLabel(){
        countLabel.setText("" + (addresBookImpl.getPersonList().size()));
    }

    public void ectionButtonPressed(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();
        if (!(source instanceof Button)){return;}

        Button clickedButton = (Button) source;
        Person selectedPerson = (Person) tableAddresView.getSelectionModel().getSelectedItem();
        Window parentWindow = ((Node) actionEvent.getSource()).getScene().getWindow();
        if (selectedPerson == null){
            selectedPerson = new Person("","");
        }
        editDialogController.setPerson(selectedPerson);

        switch (clickedButton.getId()){
            case "btnAdd":
                editDialogController.setPerson(new Person("",""));
                showDialog();
                addresBookImpl.add(editDialogController.getPerson());
                break;

            case "btnEdit":
                if (tableAddresView.getSelectionModel().getSelectedItem() != null) {
                    editDialogController.setPerson((Person) tableAddresView.getSelectionModel().getSelectedItem());
                    showDialog();
                    break;
                }else break;


            case "btnDelete":
                addresBookImpl.delete((Person) tableAddresView.getSelectionModel().getSelectedItem());
                break;
        }


    }

    private void showDialog() {
        if (editDialogStage == null) {
            editDialogStage = new Stage();
            editDialogStage.setTitle(fxmlLoader.getResources().getString("key.editingRecords"));
            editDialogStage.setMinHeight(100);
            editDialogStage.setMinWidth(400);
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(mainStage);

        }
        editDialogStage.showAndWait();
    }
}

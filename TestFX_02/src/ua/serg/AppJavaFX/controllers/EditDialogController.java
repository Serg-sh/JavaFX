package ua.serg.AppJavaFX.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ua.serg.AppJavaFX.objects.Person;

/**
 * Created by shpak on 24.06.2016.
 */
public class EditDialogController {
    @FXML
    private TextField txtFFio;
    @FXML
    private TextField txtFTel;
    @FXML
    private Button btnOk;
    @FXML
    private Button btnCancel;
    private Person person;

    // закрываем окно
    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    public void actionSave(ActionEvent actionEvent) {
        person.setFio(txtFFio.getText());
        person.setTel(txtFTel.getText());
        actionClose(actionEvent);
    }
//    Заполняем поля
    public void setPerson(Person person){
        this.person = person;
        txtFFio.setText(person.getFio());
        txtFTel.setText(person.getTel());
    }

    public Person getPerson() {
        return person;
    }
}

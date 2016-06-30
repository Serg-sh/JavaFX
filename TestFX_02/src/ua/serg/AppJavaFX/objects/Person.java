package ua.serg.AppJavaFX.objects;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by shpak on 24.06.2016.
 */
public class Person {

    public Person(){}

    public Person(String fio, String tel) {
        this.fio = new SimpleStringProperty(fio);
        this.tel = new SimpleStringProperty(tel);
    }

    private SimpleStringProperty fio = new SimpleStringProperty("");
    private SimpleStringProperty tel = new SimpleStringProperty("");

    public String getFio() {
        return fio.get();
    }

    public void setFio(String fio) {
        this.fio.set(fio);
    }

    public String getTel() {
        return tel.get();
    }

    public void setTel(String tel) {
        this.tel.set(tel);
    }

    public SimpleStringProperty fioProperty() {
        return fio;
    }

    public SimpleStringProperty telProperty() {
        return tel;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fio='" + fio + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}

package ua.serg.AppJavaFX.interfaces.impls;



import javafx.collections.ObservableList;
import ua.serg.AppJavaFX.interfaces.AddresBook;
import ua.serg.AppJavaFX.objects.Person;
import javafx.collections.FXCollections;

import java.util.ArrayList;

/**
 * Created by shpak on 24.06.2016.
 */
public class CollectionAddresBook implements AddresBook {

    private ObservableList<Person> personList = FXCollections.observableArrayList();




    @Override
    public void add(Person person) {
        personList.add(person);
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {
        personList.remove(person);
    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public void print() {
        int num = 1;
        for (Person person : personList) {
            System.out.println(num++ +")" + " ФИО = " + person.getFio() + "; Тел.: " + person.getTel());
        }
    }

    public void fillTestData() {
        personList.add(new Person("Иванов", "111 11 11"));
        personList.add(new Person("Петров", "222 22 22"));
        personList.add(new Person("Сидоров", "333 33 33"));
        personList.add(new Person("Федоров", "444 44 44"));
    }
}

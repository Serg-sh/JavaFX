package ua.serg.AppJavaFX.interfaces.impls;

import ua.serg.AppJavaFX.interfaces.AddresBook;
import ua.serg.AppJavaFX.objects.Person;

import java.util.ArrayList;

/**
 * Created by shpak on 24.06.2016.
 */
public class CollectionAddresBook implements AddresBook {

    private ArrayList<Person> personList = new ArrayList<>();


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

    public ArrayList<Person> getPersonList() {
        return personList;
    }
}

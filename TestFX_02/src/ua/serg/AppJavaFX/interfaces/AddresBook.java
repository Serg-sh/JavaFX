package ua.serg.AppJavaFX.interfaces;

import ua.serg.AppJavaFX.objects.Person;

/**
 * Created by shpak on 24.06.2016.
 */
public interface AddresBook {
    void add(Person person);

    void update(Person person);

    void delete(Person person);
}

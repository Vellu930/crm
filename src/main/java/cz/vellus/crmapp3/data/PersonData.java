package cz.vellus.crmapp3.data;

import cz.vellus.crmapp3.model.Person;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class PersonData {
    private final static HibernateUtils hiberTools = new HibernateUtils();
    private static SessionFactory factory = hiberTools.getFactory();

    public static void addPerson(Person person) {
        factory = factory == null ? hiberTools.setUpFactory() : factory;
        hiberTools.addData(person);
    }

    public static Optional<Person> findPerson(String name) {
        factory = factory == null ? hiberTools.setUpFactory() : factory;
        return Optional.ofNullable(hiberTools.findPersonByName(name));
    }

    public static List<Person> getPersonList() {
        factory = factory == null ? hiberTools.setUpFactory() : factory;
        return hiberTools.showData();
    }

    public static SessionFactory prepareFactory() {
        factory = factory == null ? hiberTools.setUpFactory() : factory;
        return factory;
    }
    public static void destroyFactory() {
        if(factory != null) factory.close();
    }


}

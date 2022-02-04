package cz.vellus.crmapp3.data;

import cz.vellus.crmapp3.model.Person;
import org.hibernate.SessionFactory;

import java.util.List;

public class PersonData {
    private final static HibernateUtils hiberTools = new HibernateUtils();
    private static SessionFactory factory = hiberTools.getFactory();

    public static void addPerson(Person person) {
        factory = factory == null ? hiberTools.setUpFactory() : factory;
        hiberTools.addData(person);
    }

    public static Person findPerson(String name) {
        factory = factory == null ? hiberTools.setUpFactory() : factory;
        return hiberTools.findPersonByName(name);
    }

    public static List<Person> getPersonList() {
        factory = factory == null ? hiberTools.setUpFactory() : factory;
        return hiberTools.showData();
    }

    public static SessionFactory prepareFactory() {
        factory = factory == null ? hiberTools.setUpFactory() : factory;
        return factory;
    }


}

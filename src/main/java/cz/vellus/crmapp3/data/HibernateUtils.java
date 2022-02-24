package cz.vellus.crmapp3.data;

import cz.vellus.crmapp3.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class HibernateUtils {

    private SessionFactory factory;

    public SessionFactory getFactory() {
        return factory;
    }

    public HibernateUtils() {
    }

    public SessionFactory setUpFactory() {

        if (factory == null) {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            try {
                factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
                System.out.println("Factory created!");
            } catch (Exception e) {
                System.err.println("Cannot build session factory... :-(");
                StandardServiceRegistryBuilder.destroy(registry);
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Factory already exists.");
        }
        return factory;
    }


    public void addData(Person p) {
        try {
            Session session = factory.openSession();
            session.beginTransaction();
            session.save(p);
            session.getTransaction().commit();
            session.close();
            System.out.println("Saving new data: "+ p.getName());
        }
        catch  (Exception e){
            System.err.println("Cannot open seesion! ");
            e.printStackTrace();
        }
    }


    public List<Person> showData() {
        List<Person> result = new ArrayList<>();
        try {
            Session session = factory.openSession();
            session.beginTransaction();
            result = session.createQuery("from Person", Person.class).getResultList();
            session.getTransaction().commit();
            session.close();
//            for ( Person per : (List<Person>) result ) {
//                System.out.println( "Person: " + per.getName());
//            }

        } catch (Exception e) {
            System.err.println("Could not open session to fetch people from DB.");
            e.printStackTrace();
        }
        return result;
    }

    public Person findPersonByName(String name) {
        Person person = null;
        String hql = "from Person P where P.name= :p_name";
        try {
            Session session = factory.openSession();
            session.beginTransaction();
            List<Person> queryList = session.createQuery(hql).setParameter("p_name", name).getResultList();
            session.getTransaction().commit();
            session.close();
            if (!queryList.isEmpty()) {
                person = queryList.get(0);
            }
            else {
                System.out.println("No person with this name found in the database.");
            }
        }
        catch (Exception e) {
            System.err.println("Could not open session to find Person.");
            e.printStackTrace();
        }
        return person;
    }

    // id is just internal item, not used
    public Person findPersonById(int id) {
        Person personFound = null;
        try {
            Session session = factory.openSession();
            session.beginTransaction();
            personFound = session.find(Person.class, id);
            session.getTransaction().commit();
            session.close();
        }
        catch (Exception e) {
            System.out.println("No person with this id found in the database.");
            System.err.println("Or could not open session to find Person.");
            e.printStackTrace();
        }
        return personFound;
    }

    public void deletePerson(String name) {
        try {
            Session session = factory.openSession();
            session.beginTransaction();
            Person person = findPersonByName(name);
            session.delete(person);
            session.getTransaction().commit();
            session.close();
            System.out.println("Person deleted: "+name);
        }
        catch (Exception e) {
            System.out.println("No person with this name found in the database.");
            System.err.println("Or could not open session to find Person.");
            e.printStackTrace();
        }
    }


}

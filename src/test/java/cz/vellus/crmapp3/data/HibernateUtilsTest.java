package cz.vellus.crmapp3.data;

import cz.vellus.crmapp3.model.Person;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

class HibernateUtilsTest {

    private static HibernateUtils utils = new HibernateUtils();
    private List<Person> personList = new ArrayList<>();
    private static SessionFactory sessionFactory;

    @BeforeAll
    static void setUp() throws Exception {
        sessionFactory = utils.setUpFactory();
    }

    @AfterAll
    static void tearDown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    void addData() {
        System.out.println("---------Adding data TEST 1:---------");
        personList.add(new Person("Paul Sanders", "London", "UK", "jack@email.com", "43653290"));
        personList.add(new Person("Gay Pam"));
        personList.add(new Person("Mary Hulk"));
        System.out.println("Number of people in local list: "+personList.size());
        for (Person p: personList) {
            utils.addData(p);
        }
    }

    @Test
    void showData() {
        System.out.println("------- Showing data TEST 4: ---------");

        Assertions.assertFalse(utils.showData().isEmpty());
    }

    @Test
    void findPersonByName() {
        System.out.println("---------Finding person by name TEST 3: ---------");
        String name = "Paul Sanders";
        String queriedName = utils.findPersonByName(name).getName();
        Assertions.assertEquals(name, queriedName);
    }
    @Test
    void findPersonById() {
        System.out.println("---------Finding person by ID TEST 5: ---------");
        Person person123 = new Person("Lucy Spring");
        utils.addData(person123);
        int id = person123.getId();
        int queriedID = utils.findPersonById(id).getId();
        Assertions.assertEquals(id, queriedID);
    }

    @Test
    void deletePerson() {
        addData();
        System.out.println("---------Deleting data TEST 2: ---------");
        Person p = utils.findPersonByName("Paul Sanders");
        utils.deletePerson(p.getName());
        personList.remove(p);
        System.out.println(utils.showData().size());
        Assertions.assertTrue(utils.showData().size()==2);
    }


}
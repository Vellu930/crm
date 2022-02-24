package cz.vellus.crmapp3.data;

import cz.vellus.crmapp3.model.Person;
import org.junit.jupiter.api.*;

import java.util.Optional;

public class PersonDataTest {

    @BeforeAll
    static void setUp() throws Exception {
        PersonData.prepareFactory();
    }

    @AfterAll
    static void tearDown() {
        PersonData.destroyFactory();
    }

    @Test
    void testAddPerson() {
    }

    @Test
    void testFindPerson() {
        Person p = new Person("Norman Sailor");
        PersonData.addPerson(p);
        Optional<Person> optionalPerson = PersonData.findPerson("Norman Wrong");
        Assertions.assertEquals("Norman Sailor",optionalPerson.orElseGet(() -> new Person("Default Joe")).getName());
    }
}

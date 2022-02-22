package cz.vellus.crmapp3.data;

import cz.vellus.crmapp3.model.Client;
import org.junit.jupiter.api.*;

import java.util.Optional;

public class ClientDataTest {

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
        Client p = new Client("Norman Sailor");
        PersonData.addPerson(p);
        Optional<Client> optionalPerson = PersonData.findPerson("Norman Wrong");
        Assertions.assertEquals("Norman Sailor",optionalPerson.orElseGet(() -> new Client("Default Joe")).getName());
    }
}

package cz.vellus.crmapp3.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import javax.mail.Message;
import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MailerTest {

    @Test
    void itShouldReadMessageTextBody() {

    }

    @Test
    void itShouldReadEmails() throws MessagingException, IOException {
        // what you need?
        Mailer mailerUnderTest = new Mailer();
        List<String> emailsOfClientsFromDB = new ArrayList<>();
        emailsOfClientsFromDB.add("noreply@wakatime.com");
        emailsOfClientsFromDB.add("ritesh1024@gmail.com");

        // what you do with it?
        List<Message> messagesFromClientsOnly = mailerUnderTest.readEmailFromUser(emailsOfClientsFromDB);
        for (Message m: messagesFromClientsOnly) {
            System.out.println(m.getSubject());
        }

        // what should the result be?
        Assertions.assertTrue(messagesFromClientsOnly.size() > 0);
    }
}
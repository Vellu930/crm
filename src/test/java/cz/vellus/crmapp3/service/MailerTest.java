package cz.vellus.crmapp3.service;

import cz.vellus.crmapp3.model.Email;
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
        List<String> emailsOfClientsFromDB = new ArrayList<>();
        emailsOfClientsFromDB.add("noreply@wakatime.com");
        emailsOfClientsFromDB.add("ritesh1024@gmail.com");

        List<Email> messagesFromClientsOnly = Mailer.readEmailFromUser(emailsOfClientsFromDB);

    }

    @Test
    void itShouldReadEmails() throws MessagingException, IOException {
        // what you need?
        List<String> emailsOfClientsFromDB = new ArrayList<>();
        emailsOfClientsFromDB.add("noreply@wakatime.com");
        emailsOfClientsFromDB.add("ritesh1024@gmail.com");
        // what you do with it?
        List<Email> messagesFromClientsOnly = Mailer.readEmailFromUser(emailsOfClientsFromDB);
        for (Email m: messagesFromClientsOnly) {
            System.out.println(m.getSubject());
        }
        // what should the result be?
        Assertions.assertTrue(messagesFromClientsOnly.size() > 0);
    }
}
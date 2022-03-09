package cz.vellus.crmapp3.service;

import cz.vellus.crmapp3.controller.MessagesController;
import cz.vellus.crmapp3.data.PersonData;
import cz.vellus.crmapp3.model.Email;
import cz.vellus.crmapp3.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GoogleMailerTest {

    @Test
    void fetchEmails() {
        MessagesController mc = new MessagesController();
        List<String> emails = mc.emailsFromDB();
        List<String> manualMail = new ArrayList<>();
        manualMail.add("noreply@github.com");
        List<Email> ems = GoogleMailer.fetchEmails(emails);
        mc.loadEmails();
        Assertions.assertTrue(ems.size()>0);

    }
}
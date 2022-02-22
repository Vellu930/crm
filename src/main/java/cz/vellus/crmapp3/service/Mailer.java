package cz.vellus.crmapp3.service;

import cz.vellus.crmapp3.model.Client;
import cz.vellus.crmapp3.model.User;

import javax.mail.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Mailer {

    //Later username will be the current user logged in
    private String userMail = "********@gmail.com";
    private String password = "********";
    private String storeType = "imap";
    private String host = "imap.gmail.com";
    // private final String recipientMail = "5580f25f35-0092af@inbox.mailtrap.io";  <-- TEST MAIL ACCOUNT

    public List<Message> readEmailFromUser(List<String> emails) {
        List<Message> clientMessages = new ArrayList<>();

        Properties props = new Properties();
        props.put("mail.imap.host", host);
        props.put("mail.imap.port", "993");
        props.put("mail.imap.starttls.enable", "true");
        props.put("mail.store.protocol", "imap");
        Session session = Session.getDefaultInstance(props);
        try {
            Store store = session.getStore("imaps");
            store.connect(host, userMail, password);

            Folder inboxFolder = store.getFolder("INBOX");
            inboxFolder.open(Folder.READ_ONLY);

            // To save memory, have only one List of messages and
            // if they DON'T match the hashmap values, then remove from list
            // and return the same list!
            Message[] messages = inboxFolder.getMessages();

            // Filter the messages and reduce them to only those that match those in client emails array

            for (Message message : messages) {
                if (emails.contains(message.getFrom()[0])) {
                    clientMessages.add(message);
                }
            }


            for (Message mess: clientMessages) {
                System.out.println("Subject: " +mess.getSubject() + ", From: " +mess.getFrom()[0]);
            }
            inboxFolder.close();
            store.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return clientMessages;
    }

    public void sendEmailToClient(User user, String clientEmail) {

    }
}

package cz.vellus.crmapp3.service;

import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;
import cz.vellus.crmapp3.model.Email;
import cz.vellus.crmapp3.model.User;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.*;

public class Mailer {

    private static final String userMail = "**********";
    private static final String password = "**********";
    private static String storeType = "imap";
    private static String host = "imap.gmail.com";
    private final String recipientMail = "5580f25f35-0092af@inbox.mailtrap.io";

    public static List<Email> readEmailFromUser(List<String> emails) {
        Properties props = new Properties();
        props.put("mail.imap.host", host);
        props.put("mail.imap.port", "993");
        props.put("mail.imap.starttls.enable", "true");
        props.put("mail.store.protocol", "imap");
        Session session = Session.getDefaultInstance(props);
        List<Email> clientMessages = new ArrayList<>();
        try {
            Store store = (IMAPStore) session.getStore("imaps");
            store.connect(host, userMail, password);
            Folder inboxFolder = (IMAPFolder) store.getFolder("INBOX");
            inboxFolder.open(Folder.READ_WRITE);
            Message[] messages = inboxFolder.getMessages();
            Email email = null;

            for (Message message : messages) {
                email = new Email();
                email.setNumber(message.getMessageNumber());
                //email.setDateSent(message.getSentDate());
                email.setSenderEmail(message.getFrom()[0].toString());
                email.setSubject(message.getSubject());
                System.out.println("Content type: "+message.getContentType());

                if (emails.contains(email.getSenderEmail())) {
                    System.out.println("sender email: "+email.getSenderEmail());
                    clientMessages.add(email);
                }
            }

            inboxFolder.close();
            store.close();


        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return clientMessages;
    }

    public static void sendEmailToClient(User user, String clientEmail) {

    }

    public static String getMIMEtextBody(Message message) throws MessagingException, IOException {
        String textBody = null;
        System.out.println(message.getContentType());
        if (message.isMimeType("text/plain")) {
            textBody = message.getContent().toString();
        }
        return textBody;
    }

}

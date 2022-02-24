package cz.vellus.crmapp3.service;

import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;
import cz.vellus.crmapp3.model.User;

import javax.mail.*;
import java.io.IOException;
import java.util.*;

public class Mailer {

    //Later username will be the current user logged in
    private static String userMail = "*********@gmail.com";
    private static String password = "*********";
    private static String storeType = "imap";
    private static String host = "imap.gmail.com";
    // private final String recipientMail = "5580f25f35-0092af@inbox.mailtrap.io";  <-- TEST MAIL ACCOUNT

    public static List<Message> readEmailFromUser(List<String> emails) {
        Properties props = new Properties();
        props.put("mail.imap.host", host);
        props.put("mail.imap.port", "993");
        props.put("mail.imap.starttls.enable", "true");
        props.put("mail.store.protocol", "imap");
        Session session = Session.getDefaultInstance(props);
        List<Message> clientMessages = new ArrayList<>();
        try {
            Store store = (IMAPStore) session.getStore("imaps");
            store.connect(host, userMail, password);

            Folder inboxFolder = (IMAPFolder) store.getFolder("INBOX");
            inboxFolder.open(Folder.READ_WRITE);
            System.out.println("Opened inbox folder...");

            Message[] messages = inboxFolder.getMessages();

            // TODO: Filter the messages and reduce them to only those that match those in client emails array
            for (Message message : messages) {
            // message.getFrom()[0]  returns usually format  "Name <email@address>"
                String fullEmailAddress = message.getFrom()[0].toString();
                String substringEmail = null;
                if(fullEmailAddress.contains("<")) {
                    substringEmail = fullEmailAddress.substring(fullEmailAddress.indexOf("<") + 1, fullEmailAddress.indexOf(">"));
                }
                else {
                    substringEmail = fullEmailAddress;
                }
                if (emails.contains(substringEmail)) {
                    clientMessages.add(message);
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

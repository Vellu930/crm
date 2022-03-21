package cz.vellus.crmapp3.service;

import com.google.api.client.util.StringUtils;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.MessagePart;
import com.google.api.services.gmail.model.MessagePartHeader;
import cz.vellus.crmapp3.model.Email;
import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GoogleMailer {
    private final String USER = "me";

    public List<Email> fetchEmails(List<String> clientMessages) {
        System.out.println("Fetching matched emails with Gmail...");
        List<Email> emails = new ArrayList<>();
        Gmail service = GmailAPI.getGmailService();
        ListMessagesResponse messagesResponse = null;
        try {
            Gmail.Users.Messages.List list = null;
            for (String mail: clientMessages) {
                 list = service.users().messages().list(USER).setQ("From: "+mail);
            }
            messagesResponse = list.execute();
            List<Message> messages = messagesResponse.getMessages();
            System.out.println("Size of list:  " + messages.size());  //max default 100
            for (Message m : messages) {
                String messageID = m.getId();
                Message message = service.users().messages().get(USER, messageID).execute();
                List<MessagePartHeader> headers = message.getPayload().getHeaders();

                String senderName = null;
                String subject = null;
                String date = null;
                String body = getMessageBody(message);
                for (MessagePartHeader h: headers) {
                    if(h.getName().equals("Subject")) {
                        subject = h.getValue();
                        System.out.println("Subject: "+subject);
                    }
                    else if(h.getName().equals("Date")) {
                        date = h.getValue();
                        System.out.println("Date: "+date);
                    }
                    else if(h.getName().equals("From")) {
                        senderName = h.getValue();
                        System.out.println("From: "+senderName.substring(0, senderName.indexOf("<")).trim());
                    }
                }
                Email email = new Email();
                email.setSenderName(senderName);
                email.setSubject(subject);
                email.setContentBody(body);
                email.setDateSent(LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE));
                emails.add(email);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emails;
    }

    private String getMessageBody(Message message) {
        // TODO: create recursive solution for nested mimeparts
        String decodedBody = null;
        String mimeType = message.getPayload().getMimeType();
        if (mimeType.contains("multipart")) {
            MessagePart part = message.getPayload().getParts().get(0);
            String encodedBody = part.getBody().getData().trim();
            decodedBody = StringUtils.newStringUtf8(Base64.decodeBase64(encodedBody));

        } else if (mimeType.contains("text/plain")) {
            String encodedBody = message.getPayload().getBody().getData();
            decodedBody = StringUtils.newStringUtf8(Base64.decodeBase64(encodedBody));
        }
        else {
            // TODO: jsoup html parser to read html message
            decodedBody = "html";
        }
        return null;
    }
}

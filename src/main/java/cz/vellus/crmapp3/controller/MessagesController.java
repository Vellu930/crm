package cz.vellus.crmapp3.controller;

import cz.vellus.crmapp3.data.PersonData;
import cz.vellus.crmapp3.model.Person;
import cz.vellus.crmapp3.service.Mailer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import javax.mail.*;

public class MessagesController extends VBox {
    @FXML private URL location;
    @FXML private ResourceBundle resources;
    @FXML private HBox answeringHolder;
    @FXML private ListView<HBox> listViewMessages;
    @FXML private VBox messagesHolder;

    public void initialize() {
        loadEmails();
    }

    private void loadEmails() {
        System.out.println("Loading client messages...");
        List<Message> clientEmails = Mailer.readEmailFromUser(fetchEmailAddressesFromDB());

        if( clientEmails.size() > 0) {
            for (Message m: clientEmails) {
                MessageItemController messageItemController = null;
                FXMLLoader loader = new FXMLLoader();
                HBox hbox = null;
                try {
                    loader.setLocation(MessageItemController.class.getResource("/cz/vellus/crmapp3/messageItem.fxml"));
                    hbox = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                messageItemController = loader.getController();
                String clientName = null;
                try {
                    clientName = m.getFrom()[0].toString().substring(0, m.getFrom()[0].toString().indexOf(" <"));
                    messageItemController.setLabelValues(clientName, m.getSentDate().toString(), m.getSubject(), " ");
                } catch (MessagingException e) {
                    e.getMessage();
                }
                listViewMessages.getItems().add(hbox);
            }
        }
        else {
            System.out.println("You don't have any emails from clients...");
            // TODO: add label notice
        }
    }

    private List<String> fetchEmailAddressesFromDB() {
        List<String> emails = new ArrayList<>();
        for (Person person: PersonData.getPersonList()) {
            emails.add(person.getEmail());
        }
        return emails;
    }

    public VBox getRootNode() {
        URL url = MessagesController.class.getResource("/cz/vellus/crmapp3/Messages.fxml");
        FXMLLoader fxml = new FXMLLoader(url);
        fxml.setRoot(this);
        fxml.setController(this);
        try {
            fxml.load();
        } catch (IOException e) {
            e.getMessage();
        }
        return fxml.getRoot();
    }
}

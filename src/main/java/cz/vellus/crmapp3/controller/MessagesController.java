package cz.vellus.crmapp3.controller;

import cz.vellus.crmapp3.data.PersonData;
import cz.vellus.crmapp3.model.Email;
import cz.vellus.crmapp3.model.Person;
import cz.vellus.crmapp3.service.GoogleMailer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessagesController extends VBox {
    @FXML
    private URL location;
    @FXML
    private ResourceBundle resources;
    @FXML
    private HBox answeringHolder;
    @FXML
    private ListView<HBox> listViewMessages;
    @FXML
    private VBox messagesHolder;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public void initialize() {
        loadEmails();
    }

    public void loadEmails() {
        logger.log(Level.INFO, "Loading client messages...");
        GoogleMailer gmailer = new GoogleMailer();
        List<Email> clientEmails = gmailer.fetchEmails(emailsFromDB());
        logger.info("sample subject: " + clientEmails.get(0).getSubject());
        if (clientEmails.size() > 0) {
            for (Email m : clientEmails) {
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
                messageItemController.setLabelValues(m.getSenderName(), m.dateString(), m.getSubject(), m.getContentBody());
                listViewMessages.getItems().add(hbox);
            }
        } else {
            logger.log(Level.INFO, "You don't have any emails from clients...");
        }
    }

    public List<String> emailsFromDB() {
        List<String> emails = new ArrayList<>();
        for (Person person : PersonData.getPersonList()) {
            emails.add(person.getEmail());
        }
        return emails;
    }

    public VBox getRootNode() {
        URL url = MessagesController.class.getResource("/cz/vellus/crmapp3/Messages.fxml");
        FXMLLoader fxml = new FXMLLoader(url);
        System.out.println("Thread state: " + Thread.currentThread().getState());
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

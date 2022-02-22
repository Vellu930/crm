package cz.vellus.crmapp3.controller;

import cz.vellus.crmapp3.service.Mailer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.mail.*;

public class MessagesController extends VBox {
    @FXML private URL location;
    @FXML private ResourceBundle resources;

    public void initialize() {
        List<String> mailsOfClients = new ArrayList<>();
        mailsOfClients.add("teraform@gmail.com");
        Mailer mailerTool = new Mailer();
        mailerTool.readEmailFromUser(mailsOfClients);
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

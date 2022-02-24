package cz.vellus.crmapp3.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class MessageItemController {

    @FXML private Label mailContent;
    @FXML private Label mailSubject;
    @FXML private Label senderName;
    @FXML private Label timeDateSent;

    @FXML
    public void initialize() {
    }

    public void setLabelValues(String name, String dateTime, String subject, String content) {
        senderName.setText(name);
        timeDateSent.setText(dateTime);
        mailSubject.setText(subject);
        mailContent.setText(content);
    }


}

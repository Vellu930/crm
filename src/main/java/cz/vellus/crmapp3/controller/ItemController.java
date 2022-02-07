package cz.vellus.crmapp3.controller;

import cz.vellus.crmapp3.data.PersonData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;

public class ItemController {
    @FXML private Label nameLabel;
    @FXML private Label sinceLabel;
    @FXML private Label cityLabel;
    @FXML private Label mailLabel;
    @FXML private Label phoneLabel;

    @FXML
    public void initialize() {
    }

    public void setLabelValues(String name, String city, String mail, String phone) {
        nameLabel.setText(name);
        cityLabel.setText(city);
        mailLabel.setText(mail);
        phoneLabel.setText(phone);
    }


}

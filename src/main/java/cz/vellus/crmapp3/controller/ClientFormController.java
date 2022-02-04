package cz.vellus.crmapp3.controller;

import cz.vellus.crmapp3.data.HibernateUtils;
import cz.vellus.crmapp3.data.PersonData;
import cz.vellus.crmapp3.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientFormController extends VBox {

    @FXML private TextField CityTextfield;
    @FXML private TextField countryTextfield;
    @FXML private TextField emailTextfield;
    @FXML private TextField nameTextfield;
    @FXML private TextField phoneTextfield;
    @FXML private Button saveNewBut;


    @FXML private URL location;
    @FXML private ResourceBundle resources;

    public void initialize() {
        saveNewBut.setOnAction((event) -> {
            PersonData.addPerson(new Person("Jake Gylenhal", "city", "country", "mailer@com", "9089756"));

        });
    }

    public ClientFormController() {
    }

    public VBox getRootNode() {
        URL url = ClientFormController.class.getResource("/cz/vellus/crmapp3/ClientForm.fxml");
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

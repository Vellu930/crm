package cz.vellus.crmapp3.controller;

import cz.vellus.crmapp3.data.PersonData;
import cz.vellus.crmapp3.util.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class RootController {
    @FXML private VBox contentBox;
    @FXML private Button clientsListBut;
    @FXML private Button eventsBut;
    @FXML private Button homeBut;
    @FXML private Button messagesBut;
    @FXML private Button newClientBut;
    @FXML private Button tasksBut;

    @FXML
    public void initialize() {
        switchToDashboard();
        PersonData.prepareFactory();
    }

    @FXML
    void switchToDashboard() {
        System.out.println("Switching to Dashboard...");
        SceneSwitcher.getDashboard(contentBox);
    }

    @FXML
    void switchToClientForm() {
        System.out.println("Switching to Client Form...");
        SceneSwitcher.getClientForm(contentBox);
    }
    @FXML
    void switchToMessages() {
        System.out.println("Switching to Messages...");
        SceneSwitcher.getMessages(contentBox);
    }

}

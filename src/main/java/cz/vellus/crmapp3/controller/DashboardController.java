package cz.vellus.crmapp3.controller;

import cz.vellus.crmapp3.data.HibernateUtils;
import cz.vellus.crmapp3.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class DashboardController extends VBox {
    @FXML private URL location;
    @FXML private ResourceBundle resources;

    public DashboardController() {
    }

    public VBox getRootNode() {
        URL url = DashboardController.class.getResource("/cz/vellus/crmapp3/Dashboard.fxml");
        FXMLLoader fxml = new FXMLLoader(url);
        fxml.setRoot(this);
        fxml.setController(this);
        try {
            fxml.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fxml.getRoot();
    }

    public void initialize() {
    }
}
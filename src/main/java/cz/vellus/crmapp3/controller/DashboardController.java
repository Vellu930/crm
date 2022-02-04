package cz.vellus.crmapp3.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController extends VBox {
    @FXML private URL location;
    @FXML private ResourceBundle resources;


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
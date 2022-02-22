package cz.vellus.crmapp3.controller;

import cz.vellus.crmapp3.data.PersonData;
import cz.vellus.crmapp3.model.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardController extends VBox {
    @FXML private URL location;
    @FXML private ResourceBundle resources;

    @FXML private VBox clientlListHolder;
    @FXML private ListView<HBox> listViewItems;

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

        List<Client> clients = PersonData.getPersonList();

        for (Client c :clients) {
            ItemController itemController = null;
            FXMLLoader loader = new FXMLLoader();
            HBox hbox = null;
            try {
                loader.setLocation(ItemController.class.getResource("/cz/vellus/crmapp3/itemClient.fxml"));
                hbox = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            itemController = loader.getController();
            itemController.setLabelValues(c.getName(), c.getCity(), c.getEmail(), c.getPhone());
            listViewItems.getItems().add(hbox);
        }
    }
}
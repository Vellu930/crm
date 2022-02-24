package cz.vellus.crmapp3.util;

import cz.vellus.crmapp3.controller.ClientFormController;
import cz.vellus.crmapp3.controller.ClientTableController;
import cz.vellus.crmapp3.controller.DashboardController;
import cz.vellus.crmapp3.controller.MessagesController;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class SceneSwitcher {

    private static DashboardController dashboard;
    private static ClientFormController clientForm;
    private static MessagesController messages;
    private static ClientTableController clientTable;

    public static void getDashboard(VBox box) {
        dashboard = new DashboardController();
        VBox vbox = dashboard.getRootNode();
        config(box, vbox);
    }

    public static void getClientForm(VBox box) {
        clientForm = new ClientFormController();
        VBox vbox = clientForm.getRootNode();
        config(box, vbox);
    }
    public static void getMessages(VBox box) {
        messages = new MessagesController();
        VBox vbox = messages.getRootNode();
        config(box, vbox);
    }
    public static void getClientTable(VBox box) {
        clientTable = new ClientTableController();
        VBox vbox = clientTable.getRootNode();
        config(box, vbox);
    }
    private static void config(VBox box, VBox content) {
        box.getChildren().clear();
        box.getChildren().add(content);
    }
}

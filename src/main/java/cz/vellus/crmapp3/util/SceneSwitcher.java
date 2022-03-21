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
        dashboard = dashboard == null ? new DashboardController(): dashboard;
        VBox vbox = dashboard.getRootNode();
        config(box, vbox);
    }

    public static void getClientForm(VBox box) {
        clientForm = clientForm == null ? new ClientFormController(): clientForm;
        VBox vbox = clientForm.getRootNode();
        config(box, vbox);
    }
    public static void getMessages(VBox box) {
        messages = messages == null ? new MessagesController(): messages;
        VBox vbox = messages.getRootNode();
        config(box, vbox);
    }
    public static void getClientTable(VBox box) {
        clientTable = clientTable == null ? new ClientTableController(): clientTable;
        VBox vbox = clientTable.getRootNode();
        config(box, vbox);
    }
    private static void config(VBox box, VBox content) {
        box.getChildren().clear();
        box.getChildren().add(content);
    }
}

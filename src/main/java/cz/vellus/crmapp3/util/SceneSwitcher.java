package cz.vellus.crmapp3.util;

import cz.vellus.crmapp3.controller.ClientFormController;
import cz.vellus.crmapp3.controller.DashboardController;
import cz.vellus.crmapp3.controller.MessagesController;
import javafx.scene.layout.VBox;

public class SceneSwitcher {
    public static final String HOME = "Dashboard.fxml";
    public static final String MESSAGES = "Messages.fxml";
    public static final String TASKS = "Tasks.fxml";
    public static final String EVENTS = "Events.fxml";
    public static final String CLIENTS = "Clients.fxml";
    public static final String NEW_CLIENT_FORM = "ClientForm.fxml";

    private static DashboardController dashboard;
    private static ClientFormController clientForm;
    private static MessagesController messages;

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
    private static void config(VBox box, VBox content) {
        box.getChildren().clear();
        box.getChildren().add(content);
    }
}

package cz.vellus.crmapp3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CRMapp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CRMapp.class.getResource("/cz/vellus/crmapp3/Root.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        // scene.getStylesheets().add(getClass().getResource("cz/vellus/crmapp3/coolStyles.css").toExternalForm());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
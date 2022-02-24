package cz.vellus.crmapp3.controller;

import cz.vellus.crmapp3.data.PersonData;
import cz.vellus.crmapp3.model.Person;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;

public class ClientTableController extends VBox {

    @FXML private TextField filterField;
    @FXML private TableView<Person> clientsTable;
    @FXML private TableColumn<Person, Integer> idColumn;
    @FXML private TableColumn<Person, String> nameColumn;
    @FXML private TableColumn<Person, String> cityColumn;
    @FXML private TableColumn<Person, String> countryColumn;
    @FXML private TableColumn<Person, String> phoneColumn;
    @FXML private TableColumn<Person, String> emailColumn;
    // @FXML private TableColumn<Person, String> sinceColumn;
    private ObservableList<Person> clientsObserver;

    public VBox getRootNode() {
        URL url = ClientTableController.class.getResource("/cz/vellus/crmapp3/clientTable.fxml");
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
        loadDataInTable();
    }

    void loadDataInTable() {
        clientsObserver = FXCollections.observableArrayList(PersonData.getPersonList());
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        FilteredList<Person> filteredList = new FilteredList<>(clientsObserver);

        ChangeListener<String> listener = (observable, oldValue, newValue) -> {
            filteredList.setPredicate(p -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String searchedValue = newValue.toLowerCase();
                if (p.getName().toLowerCase().contains(searchedValue)) {
                    return true;
                }
                if (p.getCity() != null) {
                    if (p.getCity().toLowerCase().contains(searchedValue)) {
                        return true;
                    }
                }
                if (p.getCountry() != null) {
                    System.out.println(p.getCountry());
                    if (p.getCountry().toLowerCase().contains(searchedValue)) {
                        return true;
                    }
                }
                if (p.getEmail() != null) {
                    if (p.getEmail().toLowerCase().contains(searchedValue)) {
                        return true;
                    }
                }
                if (p.getPhone() != null) {
                    System.out.println(p.getPhone());
                    if (p.getPhone().toLowerCase().contains(searchedValue)) {
                        return true;
                    }
                }
                return false;
            });
        };

        filterField.textProperty().addListener(listener);

        clientsTable.setItems(filteredList);

    }

    @FXML
    void rowEditable() {
        ObservableList<TablePosition> editableRows = clientsTable.getSelectionModel().getSelectedCells();

    }

    @FXML
    void removeRow() {

    }

}


package cz.vellus.crmapp3.controller;

import cz.vellus.crmapp3.data.PersonData;
import cz.vellus.crmapp3.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;

public class ClientTableController extends VBox {

    @FXML private TextField nameFilter;
    @FXML private TextField cityFilter;
    @FXML private TextField countryFilter;
    @FXML private TextField emailFilter;
    @FXML private TextField phoneFilter;
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

        FilteredList<Person> filteredList = new FilteredList<>(clientsObserver, v -> true);
        filterByName(filteredList);
        filterByCity(filteredList);
        filterByCountry(filteredList);
        filterByEmail(filteredList);
        filterByPhone(filteredList);
        clientsTable.setItems(filteredList);

    }

    private void filterByCity(FilteredList<Person> filteredList) {
        cityFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(p -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String searchedValue = newValue.toLowerCase();
                if (p.getCity() != null) {
                    if (p.getCity().toLowerCase().contains(searchedValue)) {
                    return true;
                    }
                }
                return false;
            });
        });
    }

    private void filterByName(FilteredList<Person> filteredList) {
        nameFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(p -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String searchedValue = newValue.toLowerCase();
                if (p.getName().toLowerCase().contains(searchedValue)) {
                    return true;
                }
                return false;
            });
        });
    }

    private void filterByCountry(FilteredList<Person> filteredList) {
        countryFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(p -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String searchedValue = newValue.toLowerCase();
                if (p.getCountry() != null) {
                    if (p.getCountry().toLowerCase().contains(searchedValue)) {
                        return true;
                    }
                }
                return false;
            });
        });
    }
    private void filterByEmail(FilteredList<Person> filteredList) {
        emailFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(p -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String searchedValue = newValue.toLowerCase();
                if (p.getEmail() != null) {
                    if (p.getEmail().toLowerCase().contains(searchedValue)) {
                        return true;
                    }
                }
                return false;
            });
        });
    }

    private void filterByPhone(FilteredList<Person> filteredList) {
        phoneFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(p -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String searchedValue = newValue.toLowerCase();
                if (p.getPhone() != null) {
                    if (p.getPhone().toLowerCase().contains(searchedValue)) {
                        return true;
                    }
                }
                return false;
            });
        });
    }


}


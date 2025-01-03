package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import models.Book;

import java.io.IOException;
import java.util.List;

import client.ClientController;

public class SearchController {

    @FXML
    private TextField searchField;

    @FXML
    private TableView<Book> resultsTable;
    @FXML
    private TableColumn<Book, String> titleColumn;
    @FXML
    private TableColumn<Book, String> authorColumn;
    @FXML
    private TableColumn<Book, String> subjectColumn;
    @FXML
    private TableColumn<Book, Integer> availableCopiesColumn;
    @FXML
    private TableColumn<Book, String> locationColumn;
    @FXML
    private TableColumn<Book, String> nearestReturnColumn;

    @FXML
    private HBox backToLoginContainer; // Reference to the HBox containing the Back to Login button

    //private ClientController clientController = new ClientController();
    private boolean isGuest = false; // Flag to track whether the user is a guest

    @FXML
    public void initialize() {
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        authorColumn.setCellValueFactory(cellData -> cellData.getValue().authorProperty());
        subjectColumn.setCellValueFactory(cellData -> cellData.getValue().subjectProperty());
        availableCopiesColumn.setCellValueFactory(cellData -> cellData.getValue().availableCopiesProperty().asObject());
        locationColumn.setCellValueFactory(cellData -> cellData.getValue().locationProperty());
        nearestReturnColumn.setCellValueFactory(cellData -> cellData.getValue().nearestReturnDateProperty());

        // Control the visibility of the Back to Login button
        backToLoginContainer.setVisible(isGuest);
    }

    /**
     * Perform a search based on the query entered in the search field.
     */
    @FXML
    public void performSearch() {
        String query = searchField.getText().trim();

        if (query.isEmpty()) {
            showAlert("Error", "Search field cannot be empty. Please enter a valid query.");
            return;
        }

        List<Book> results = ClientController.getInstance().searchBooks(query);

        if (results.isEmpty()) {
            showAlert("No Results", "No books found matching the search criteria.");
        } else {
            ObservableList<Book> observableResults = FXCollections.observableArrayList(results);
            resultsTable.setItems(observableResults);
        }
    }

    /**
     * Navigate back to the login page.
     */
    @FXML
    public void navigateToLogin() {
        try {
            Stage stage = (Stage) searchField.getScene().getWindow();
            Scene loginScene = new Scene(FXMLLoader.load(getClass().getResource("/views/login.fxml")));
            stage.setScene(loginScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Set whether the user is a guest.
     * @param isGuest true if the user is a guest; false otherwise.
     */
    public void setGuestMode(boolean isGuest) {
        this.isGuest = isGuest;
        if (backToLoginContainer != null) {
            backToLoginContainer.setVisible(isGuest);
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}





package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class SubscriberDashboardController {

    @FXML
    private StackPane mainContentArea;

    @FXML
    public void showSearchBooks() {
        loadView("/views/search.fxml");
    }

    @FXML
    public void showBorrowedBooks() {
        loadView("/views/borrowedBooks.fxml");
    }

    @FXML
    public void showReservations() {
        loadView("/views/reservations.fxml");
    }

    @FXML
    public void showNotifications() {
        loadView("/views/notifications.fxml");
    }

    @FXML
    public void showAccountInfo() {
        loadView("/views/accountInfo.fxml");
    }

    @FXML
    public void logout() {
        // Navigate back to the login page
        try {
            Parent loginView = FXMLLoader.load(getClass().getResource("/views/login.fxml")); // Cast to Parent
            mainContentArea.getScene().setRoot(loginView); // Set the root of the scene
        } catch (IOException e) {
            showAlert("Error", "Unable to load the login page.");
        }
    }

    private void loadView(String fxmlPath) {
        try {
            Node view = FXMLLoader.load(getClass().getResource(fxmlPath));
            mainContentArea.getChildren().clear();
            mainContentArea.getChildren().add(view);
        } catch (IOException e) {
            showAlert("Error", "Unable to load the view.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}


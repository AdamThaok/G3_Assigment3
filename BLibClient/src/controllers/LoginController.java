package controllers;

import client.ClientController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import models.User;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    //private ClientController clientController = new ClientController();

    @FXML
    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Username and Password cannot be empty.");
            return;
        }

        // Use the mockLogin method
        User user = ClientController.getInstance().Login(username, password);

        if (user == null) {
            showAlert("Login Failed", "Invalid username or password.");
        } else {
            navigateToRole(user.getRole());
        }
    }

    @FXML
    private void navigateToSearch() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/search.fxml"));
            Parent root = loader.load();

            // Set guest mode
            SearchController searchController = loader.getController();
            searchController.setGuestMode(true); // Set to false if logged in as a subscriber

            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Unable to load the search page.");
        }
    }

    private void navigateToRole(String role) {
        try {
            Stage stage = (Stage) usernameField.getScene().getWindow();
            Scene scene;

            if (role.equals("Subscriber")) {
                // Load Subscriber Dashboard
                scene = new Scene(FXMLLoader.load(getClass().getResource("/views/subscriberDashboard.fxml")));
            } else if (role.equals("Librarian")) {
                // Load Librarian Dashboard (if implemented)
                scene = new Scene(FXMLLoader.load(getClass().getResource("/views/librarianDashboard.fxml")));
            } else {
                // Default behavior for unknown roles
                showAlert("Error", "Unknown role: " + role);
                return;
            }

            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Unable to load the dashboard for role: " + role);
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


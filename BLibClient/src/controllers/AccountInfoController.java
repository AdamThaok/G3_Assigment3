package controllers;

import client.ClientController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.LibrarySubscriber;

public class AccountInfoController {

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField emailField;

    @FXML
    private Label feedbackLabel;

    private ClientController clientController = ClientController.getInstance();

    @FXML
    public void initialize() {
        // Load the subscriber's current details
        LibrarySubscriber subscriber = clientController.getMockSubscriber();
        phoneNumberField.setText(subscriber.getSubscriberCard().getPhone());
        emailField.setText(subscriber.getSubscriberCard().getEmail());
    }

    @FXML
    public void handleUpdate() {
        String newPhoneNumber = phoneNumberField.getText().trim();
        String newEmail = emailField.getText().trim();

        if (newPhoneNumber.isEmpty() || newEmail.isEmpty()) {
            feedbackLabel.setText("All fields must be filled!");
            feedbackLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        // Update the subscriber's details
        LibrarySubscriber subscriber = clientController.getMockSubscriber();
        subscriber.getSubscriberCard().setPhone(newPhoneNumber);
        subscriber.getSubscriberCard().setEmail(newEmail);

        // Simulate sending updated info to the server
        clientController.updateSubscriber(subscriber);

        // Provide feedback to the user
        feedbackLabel.setText("Information updated successfully!");
        feedbackLabel.setStyle("-fx-text-fill: green;");
    }
}




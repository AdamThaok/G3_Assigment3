package controllers;

import client.ClientController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.Notification;

import java.util.List;

public class NotificationsController {

    @FXML
    private TableView<Notification> notificationsTable;

    @FXML
    private TableColumn<Notification, String> messageColumn;

    @FXML
    private TableColumn<Notification, String> timeColumn;

    @FXML
    private TableColumn<Notification, String> methodColumn;

    @FXML
    public void initialize() {
        messageColumn.setCellValueFactory(cellData -> cellData.getValue().messageProperty());
        timeColumn.setCellValueFactory(cellData -> 
            new SimpleStringProperty(cellData.getValue().getFormattedSentAt()));
        methodColumn.setCellValueFactory(cellData -> cellData.getValue().deliveryMethodProperty());

        loadNotifications();
    }


    private void loadNotifications() {
        // Fetch mock notifications from ClientController
        List<Notification> notifications = ClientController.getInstance().getMockNotifications();
        ObservableList<Notification> observableNotifications = FXCollections.observableArrayList(notifications);
        notificationsTable.setItems(observableNotifications);
    }

    @FXML
    private void navigateToDashboard() {
        // Implement navigation back to the dashboard
        // This will depend on your application's structure
    }
}


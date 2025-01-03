package controllers;

import client.ClientController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.Order;

import java.time.LocalDate;
import java.util.List;

public class ReservationsController {

    @FXML
    private TableView<Order> ordersTable;

    @FXML
    private TableColumn<Order, Integer> orderIdColumn;
    @FXML
    private TableColumn<Order, Integer> bookIdColumn;
    @FXML
    private TableColumn<Order, LocalDate> orderDateColumn;
    @FXML
    private TableColumn<Order, LocalDate> expirationDateColumn;
    @FXML
    private TableColumn<Order, String> statusColumn;
    @FXML
    private TableColumn<Order, Button> actionsColumn;

    //private ClientController clientController = new ClientController();

    @FXML
    public void initialize() {
        // Bind columns to Order properties
        orderIdColumn.setCellValueFactory(cellData -> cellData.getValue().orderIdProperty().asObject());
        bookIdColumn.setCellValueFactory(cellData -> cellData.getValue().bookIdProperty().asObject());
        orderDateColumn.setCellValueFactory(cellData -> cellData.getValue().orderDateProperty());
        expirationDateColumn.setCellValueFactory(cellData -> cellData.getValue().expirationDateProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        actionsColumn.setCellFactory(param -> new TableCell<>() {
            @Override
            protected void updateItem(Button item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    Button cancelButton = new Button("Cancel");
                    cancelButton.setOnAction(e -> handleCancelOrder(getTableRow().getItem()));
                    setGraphic(cancelButton);
                }
            }
        });

        // Load mock data
        loadOrders();
    }

    private void loadOrders() {
        List<Order> mockOrders = ClientController.getInstance().getMockOrders();
        ObservableList<Order> observableOrders = FXCollections.observableArrayList(mockOrders);
        ordersTable.setItems(observableOrders);
    }

    private void handleCancelOrder(Order order) {
        System.out.println("Order canceled: " + order.getOrderId());
        // Implement cancellation logic (e.g., update the status)
    }
}


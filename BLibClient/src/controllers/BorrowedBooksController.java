package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import models.BorrowRecord;

import java.time.LocalDate;
import java.util.List;

import client.ClientController;

public class BorrowedBooksController {

    @FXML
    private TableView<BorrowRecord> borrowedBooksTable;

    @FXML
    private TableColumn<BorrowRecord, String> titleColumn;
    @FXML
    private TableColumn<BorrowRecord, LocalDate> borrowDateColumn;
    @FXML
    private TableColumn<BorrowRecord, LocalDate> dueDateColumn;
    @FXML
    private TableColumn<BorrowRecord, String> statusColumn;

    @FXML
    public void initialize() {
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        borrowDateColumn.setCellValueFactory(cellData -> cellData.getValue().borrowDateProperty());
        dueDateColumn.setCellValueFactory(cellData -> cellData.getValue().dueDateProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        // Mock data
        List<BorrowRecord> mockBorrowedBooks = ClientController.getInstance().getMockBorrowedBooks();
        ObservableList<BorrowRecord> observableRecords = FXCollections.observableArrayList(mockBorrowedBooks);
        borrowedBooksTable.setItems(observableRecords);
    }
}


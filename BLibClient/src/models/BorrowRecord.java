package models;

import javafx.beans.property.*;

import java.time.LocalDate;

public class BorrowRecord {

    private final StringProperty title;
    private final ObjectProperty<LocalDate> borrowDate;
    private final ObjectProperty<LocalDate> dueDate;
    private final StringProperty status;

    public BorrowRecord(String title, LocalDate borrowDate, LocalDate dueDate, String status) {
        this.title = new SimpleStringProperty(title);
        this.borrowDate = new SimpleObjectProperty<>(borrowDate);
        this.dueDate = new SimpleObjectProperty<>(dueDate);
        this.status = new SimpleStringProperty(status);
    }

    public StringProperty titleProperty() { return title; }
    public ObjectProperty<LocalDate> borrowDateProperty() { return borrowDate; }
    public ObjectProperty<LocalDate> dueDateProperty() { return dueDate; }
    public StringProperty statusProperty() { return status; }
}


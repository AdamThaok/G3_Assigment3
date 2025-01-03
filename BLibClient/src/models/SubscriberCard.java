package models;

import javafx.beans.property.*;
import javafx.collections.FXCollections;

import java.util.List;

public class SubscriberCard {

    private final StringProperty email;
    private final StringProperty phone;
    private final ListProperty<BorrowRecord> borrowingHistory;
    private final ListProperty<String> usageIssues;

    public SubscriberCard(String email, String phone, List<BorrowRecord> borrowingHistory, List<String> usageIssues) {
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleStringProperty(phone);
        this.borrowingHistory = new SimpleListProperty<>(FXCollections.observableArrayList(borrowingHistory));
        this.usageIssues = new SimpleListProperty<>(FXCollections.observableArrayList(usageIssues));
    }

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public ListProperty<BorrowRecord> borrowingHistoryProperty() {
        return borrowingHistory;
    }

    public ListProperty<String> usageIssuesProperty() {
        return usageIssues;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public List<BorrowRecord> getBorrowingHistory() {
        return borrowingHistory.get();
    }

    public List<String> getUsageIssues() {
        return usageIssues.get();
    }
}


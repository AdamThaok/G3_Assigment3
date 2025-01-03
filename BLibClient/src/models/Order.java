package models;

import javafx.beans.property.*;
import java.time.LocalDate;

public class Order {

    private final IntegerProperty orderId;
    private final IntegerProperty bookId;
    private final StringProperty subscriptionNumber;
    private final ObjectProperty<LocalDate> orderDate;
    private final StringProperty status;
    private final ObjectProperty<LocalDate> expirationDate;

    public Order(int orderId, int bookId, String subscriptionNumber, LocalDate orderDate, String status, LocalDate expirationDate) {
        this.orderId = new SimpleIntegerProperty(orderId);
        this.bookId = new SimpleIntegerProperty(bookId);
        this.subscriptionNumber = new SimpleStringProperty(subscriptionNumber);
        this.orderDate = new SimpleObjectProperty<>(orderDate);
        this.status = new SimpleStringProperty(status);
        this.expirationDate = new SimpleObjectProperty<>(expirationDate);
    }

    public IntegerProperty orderIdProperty() {
        return orderId;
    }

    public IntegerProperty bookIdProperty() {
        return bookId;
    }

    public StringProperty subscriptionNumberProperty() {
        return subscriptionNumber;
    }

    public ObjectProperty<LocalDate> orderDateProperty() {
        return orderDate;
    }

    public StringProperty statusProperty() {
        return status;
    }

    public ObjectProperty<LocalDate> expirationDateProperty() {
        return expirationDate;
    }

    public int getOrderId() {
        return orderId.get();
    }

    public int getBookId() {
        return bookId.get();
    }

    public String getSubscriptionNumber() {
        return subscriptionNumber.get();
    }

    public LocalDate getOrderDate() {
        return orderDate.get();
    }

    public String getStatus() {
        return status.get();
    }

    public LocalDate getExpirationDate() {
        return expirationDate.get();
    }
}


package models;

import javafx.beans.property.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Notification {

    private final StringProperty message;
    private final ObjectProperty<LocalDateTime> sentAt;
    private final StringProperty deliveryMethod;

    public Notification(String message, LocalDateTime sentAt, String deliveryMethod) {
        this.message = new SimpleStringProperty(message);
        this.sentAt = new SimpleObjectProperty<>(sentAt);
        this.deliveryMethod = new SimpleStringProperty(deliveryMethod);
    }

    // Getters for JavaFX Properties
    public StringProperty messageProperty() {
        return message;
    }

    public ObjectProperty<LocalDateTime> sentAtProperty() {
        return sentAt;
    }

    public StringProperty deliveryMethodProperty() {
        return deliveryMethod;
    }

    // Convenience Getters and Setters
    public String getMessage() {
        return message.get();
    }

    public void setMessage(String message) {
        this.message.set(message);
    }

    public LocalDateTime getSentAt() {
        return sentAt.get();
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt.set(sentAt);
    }

    public String getDeliveryMethod() {
        return deliveryMethod.get();
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod.set(deliveryMethod);
    }

    // Utility method to format LocalDateTime for display
    public String getFormattedSentAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return sentAt.get() != null ? sentAt.get().format(formatter) : "N/A";
    }
}



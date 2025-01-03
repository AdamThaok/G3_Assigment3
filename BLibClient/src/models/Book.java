package models;

import javafx.beans.property.*;

public class Book {
    private final IntegerProperty bookId;
    private final StringProperty title;
    private final StringProperty author;
    private final StringProperty subject;
    private final StringProperty location;
    private final IntegerProperty availableCopies;
    private final StringProperty barcode;
    private final StringProperty nearestReturnDate; // For the next available return date

    // Constructor
    public Book(int bookId, String title, String author, String subject, String location, int availableCopies, String barcode, String nearestReturnDate) {
        this.bookId = new SimpleIntegerProperty(bookId);
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.subject = new SimpleStringProperty(subject);
        this.location = new SimpleStringProperty(location);
        this.availableCopies = new SimpleIntegerProperty(availableCopies);
        this.barcode = new SimpleStringProperty(barcode);
        this.nearestReturnDate = new SimpleStringProperty(nearestReturnDate);
    }

    // Getters and setters for each property
    public int getBookId() {
        return bookId.get();
    }

    public void setBookId(int bookId) {
        this.bookId.set(bookId);
    }

    public IntegerProperty bookIdProperty() {
        return bookId;
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public StringProperty titleProperty() {
        return title;
    }

    public String getAuthor() {
        return author.get();
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public StringProperty authorProperty() {
        return author;
    }

    public String getSubject() {
        return subject.get();
    }

    public void setSubject(String subject) {
        this.subject.set(subject);
    }

    public StringProperty subjectProperty() {
        return subject;
    }

    public String getLocation() {
        return location.get();
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public StringProperty locationProperty() {
        return location;
    }

    public int getAvailableCopies() {
        return availableCopies.get();
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies.set(availableCopies);
    }

    public IntegerProperty availableCopiesProperty() {
        return availableCopies;
    }

    public String getBarcode() {
        return barcode.get();
    }

    public void setBarcode(String barcode) {
        this.barcode.set(barcode);
    }

    public StringProperty barcodeProperty() {
        return barcode;
    }

    public String getNearestReturnDate() {
        return nearestReturnDate.get();
    }

    public void setNearestReturnDate(String nearestReturnDate) {
        this.nearestReturnDate.set(nearestReturnDate);
    }

    public StringProperty nearestReturnDateProperty() {
        return nearestReturnDate;
    }

    // ToString for debugging
    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + getBookId() +
                ", title='" + getTitle() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", subject='" + getSubject() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", availableCopies=" + getAvailableCopies() +
                ", barcode='" + getBarcode() + '\'' +
                ", nearestReturnDate='" + getNearestReturnDate() + '\'' +
                '}';
    }
}


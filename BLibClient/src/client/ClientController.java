package client;

import models.Book;
import models.BorrowRecord;
import models.LibrarySubscriber;
import models.Notification;
import models.Order;
import models.SubscriberCard;
import models.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClientController {

    private static ClientController instance;

    // Private constructor to prevent instantiation
    private ClientController() {}

    // Method to get the single instance of ClientController
    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    /**
     * Simulates searching for books based on a query.
     * @param query The search query entered by the user.
     * @return A list of books matching the query.
     */
    public List<Book> searchBooks(String query) {
        // Mock data simulating books from a server
        List<Book> mockBooks = List.of(
            new Book(1, "Effective Java", "Joshua Bloch", "Programming", "Shelf 5B", 0, "1234567890123", "2025-01-15"),
            new Book(2, "Java: The Complete Reference", "Herbert Schildt", "Programming", "Shelf 3A", 3, "1234567890124", ""),
            new Book(3, "Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma", "Software Design", "Shelf 2C", 2, "1234567890125", "")
        );

        // Filter books based on the query
        List<Book> results = new ArrayList<>();
        for (Book book : mockBooks) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                book.getSubject().toLowerCase().contains(query.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                results.add(book);
            }
        }

        return results; // Return filtered results
    }

    /**
     * Simulates login validation by checking mock data.
     * @param username The username entered by the user.
     * @param password The password entered by the user.
     * @return A User object if the credentials are valid; otherwise, null.
     */
    public User Login(String username, String password) {
        // Mock user data
        List<User> mockUsers = List.of(
            new User(1, "subscriber", "123", "Subscriber"),
            new User(2, "librarian", "admin", "Librarian")
        );

        // Validate credentials
        for (User user : mockUsers) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // Return the User object if credentials match
            }
        }
        return null; // Invalid credentials
    }

    /**
     * Simulates fetching a list of borrowed books.
     * @return A list of BorrowRecord objects.
     */
    public List<BorrowRecord> getMockBorrowedBooks() {
        return List.of(
            new BorrowRecord("Effective Java", LocalDate.now().minusDays(10), LocalDate.now().plusDays(4), "Active"),
            new BorrowRecord("Clean Code", LocalDate.now().minusDays(15), LocalDate.now().plusDays(2), "Overdue")
        );
    }

    /**
     * Simulates fetching a list of orders placed by a subscriber.
     * @return A list of Order objects.
     */
    public List<Order> getMockOrders() {
        return List.of(
            new Order(1, 101, "SUB123", LocalDate.now().minusDays(1), "Active", LocalDate.now().plusDays(2)),
            new Order(2, 102, "SUB123", LocalDate.now(), "Active", LocalDate.now().plusDays(2)),
            new Order(3, 103, "SUB123", LocalDate.now(), "Canceled", LocalDate.now().plusDays(2))
        );
    }

    /**
     * Simulates fetching a list of notifications for the subscriber.
     * @return A list of Notification objects.
     */
    public List<Notification> getMockNotifications() {
        return List.of(
            new Notification("Your book 'Effective Java' is due tomorrow.", LocalDateTime.now().minusDays(1), "Email"),
            new Notification("Your reservation for 'Clean Code' is available for pickup.", LocalDateTime.now().minusHours(5), "SMS"),
            new Notification("Library will be closed on New Year's Day.", LocalDateTime.now().minusDays(2), "In-App")
        );
    }


    /**
     * Simulates fetching a mock subscriber with details and a subscriber card.
     * @return A LibrarySubscriber object with mock data.
     */
    public LibrarySubscriber getMockSubscriber() {
        SubscriberCard card = new SubscriberCard(
            "john.doe@example.com",
            "123-456-7890",
            List.of(
                new BorrowRecord("Effective Java", LocalDate.now().minusDays(10), LocalDate.now().plusDays(4), "Active"),
                new BorrowRecord("Clean Code", LocalDate.now().minusDays(15), LocalDate.now().plusDays(2), "Overdue")
            ),
            List.of("Late return of 'Clean Code'")
        );

        return new LibrarySubscriber("John Doe", "SUB123", card);
    }

    /**
     * Updates the subscriber details (mock implementation).
     * @param updatedSubscriber The updated subscriber object.
     */
    public void updateSubscriber(LibrarySubscriber updatedSubscriber) {
        // Simulate updating the subscriber in the database
        System.out.println("Subscriber details updated: " + updatedSubscriber.getName());
    }
}





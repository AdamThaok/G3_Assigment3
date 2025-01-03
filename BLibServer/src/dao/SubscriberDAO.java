package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entities.*;
import enums.ErrorCode;
import exceptions.*;
public class SubscriberDAO {

    private Connection connection;

    // Constructor to initialize database connection
    public SubscriberDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Retrieves subscriber data by card number
     * @param subscriptionNumber the unique subscription/card number of the subscriber
     * @return a Subscriber object if found, null otherwise
     */
    public Subscriber getSubscriberByCard(int subscriptionNumber) {
        String query = "SELECT * FROM subscribers WHERE subscription_number = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, subscriptionNumber);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Subscriber subscriber = new Subscriber();
                subscriber.setSubscriberId(rs.getInt("subscriberId"));
                subscriber.setName(rs.getString("name"));
                subscriber.setUsername(rs.getString("username"));
                subscriber.setPhone(rs.getString("phone"));
                subscriber.setStatus(rs.getString("status"));
                subscriber.setPenaltyReason(rs.getString("penaltyReason"));
                subscriber.setEmail(rs.getString("email"));
                return subscriber;
           
            }
            else {
                throw new SubscriberException(ErrorCode.USER_DOESNT_EXIST);
            }
           
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Adds a new subscriber to the database
     * @param subscriber the Subscriber object containing subscriber details
     * @return true if subscriber is successfully added, false otherwise
     */
    public boolean addSubscriber(Subscriber subscriber) {

        String query = "INSERT INTO subscribers (name, username, phone, status, penaltyReason, email, subscription_number) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, subscriber.getName());
            stmt.setString(2, subscriber.getUsername());
            stmt.setString(3, subscriber.getPhone());
            stmt.setString(4, subscriber.getStatus());
            stmt.setString(5, subscriber.getPenaltyReason());
            stmt.setString(6, subscriber.getEmail());
            stmt.setInt(7, subscriber.getSubscriberId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * Updates the status of an existing subscriber
     * @param subscriberId the unique ID of the subscriber
     * @param status the new status to set (e.g., active, suspended)
     * @return true if the status is updated, false otherwise
     */
    public Boolean updateSubscriberStatus(int subscriberId, String status) {

        
        String query = "UPDATE subscribers SET status = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, status);
            stmt.setInt(2, subscriberId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

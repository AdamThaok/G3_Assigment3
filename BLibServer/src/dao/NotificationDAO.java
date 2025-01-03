package dao;
import entities.*;
//========================
//NotificationDAO
//========================
public class NotificationDAO {

 /**
  * Adds a notification to the database
  * @param notification the Notification object to add
  * @return the generated ID of the new notification, or -1 if operation fails
  */
 public int addNotification(Notification notification) {
     // TODO: Insert notification into DB
     return -1; // placeholder return value
 }

 /**
  * Fetches pending notifications for a subscriber
  * @param subscriberId the unique ID of the subscriber
  * @return a List of pending Notification objects
  */
 public List<Notification> fetchPendingNotifications(int subscriberId) {
     // TODO: Retrieve pending notifications from DB
     return new ArrayList<>(); // placeholder return value
 }

 /**
  * Updates the status of a notification (e.g., "sent", "read")
  * @param notificationId the unique ID of the notification
  * @param status the new status to set
  * @return true if update is successful, false otherwise
  */
 public boolean updateNotificationStatus(int notificationId, String status) {
     // TODO: Update notification status in DB
     return false; // placeholder return value
 }
}


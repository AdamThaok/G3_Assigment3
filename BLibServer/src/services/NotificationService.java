package services;
import entities.*;
import exeptions.*;
//========================
//NotificationService
//========================
public class NotificationService {

 /**
  * Sends notifications to a subscriber
  * @param subscriptionNumber the subscriber's unique card number
  * @param message the message content to be sent
  * @param method the delivery method (e.g., "email", "sms", etc.)
  * @return true if notification is sent successfully, false otherwise
  */
 public boolean notifySubscriber(String subscriptionNumber, String message, String method) {
     // TODO: Implement notification sending logic (e.g., email, SMS, push notification)
     return false; // placeholder return value
 }

 /**
  * Fetches all pending notifications for a subscriber
  * @param subscriberId the unique ID of the subscriber
  * @return a List of Notification objects
  */
 public List<Notification> fetchNotifications(int subscriberId) {
     // TODO: Fetch pending notifications from the data store
     return new ArrayList<>(); // placeholder return value
 }
}

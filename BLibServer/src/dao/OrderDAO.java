package dao;
import entities.*;
//========================
//OrderDAO
//========================
public class OrderDAO {

 /**
  * Places a new order for a book
  * @param bookId the unique ID of the book
  * @param subscriptionNumber the subscriber's card number
  * @return the generated ID of the new order, or -1 if the operation fails
  */
 public int placeOrder(int bookId, String subscriptionNumber) {
     // TODO: Insert order record into DB
     return -1; // placeholder return value
 }

 /**
  * Retrieves all active orders for a given book
  * @param bookId the unique ID of the book
  * @return a List of Order objects that are still active
  */
 public List<Order> fetchActiveOrders(int bookId) {
     // TODO: Fetch active orders from DB
     return new ArrayList<>(); // placeholder return value
 }

 /**
  * Updates the status of an order (e.g., "placed", "fulfilled", "cancelled")
  * @param orderId the unique ID of the order
  * @param status the new status to set
  * @return true if update is successful, false otherwise
  */
 public boolean updateOrderStatus(int orderId, String status) {
     // TODO: Update order status in DB
     return false; // placeholder return value
 }

 /**
  * Cancels orders not fulfilled within two days
  * @return the number of orders cancelled
  */
 public int cancelExpiredOrders() {
     // TODO: Identify and cancel expired orders in DB
     return 0; // placeholder return value
 }
}


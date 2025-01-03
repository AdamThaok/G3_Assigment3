package dao;
import entities.*;
//========================
//BorrowRecordDAO
//========================
public class BorrowRecordDAO {

 /**
  * Adds a new borrowing record
  * @param record the BorrowRecord object to add
  * @return the generated ID of the new borrow record, or -1 if the operation fails
  */
 public int addBorrowRecord(BorrowRecord record) {
     // TODO: Insert borrow record into DB
     return -1; // placeholder return value
 }

 /**
  * Updates a borrowing record (e.g., for extensions)
  * @param borrowRecordId the unique ID of the borrow record
  * @param newDueDate the new due date
  * @return true if update is successful, false otherwise
  */
 public boolean updateBorrowRecord(int borrowRecordId, Date newDueDate) {
     // TODO: Update borrow record in DB
     return false; // placeholder return value
 }

 /**
  * Deletes a borrowing record upon return
  * @param borrowRecordId the unique ID of the borrow record
  * @return true if deletion is successful, false otherwise
  */
 public boolean deleteBorrowRecord(int borrowRecordId) {
     // TODO: Delete borrow record from DB
     return false; // placeholder return value
 }
}


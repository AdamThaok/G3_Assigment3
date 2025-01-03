package services;
import entities.*;
import dao.*;
import exceptions.*;
import java.sql.Date;

//========================
//BorrowService
//========================
public class BorrowService {
	int globalVarRecordID=0;

 /**
  * Processes borrowing requests
  * @param barcode the barcode of the book to borrow
  * @param subscriberId the ID (or card number) of the subscriber
  * @return true if the borrow operation is successful, false otherwise
  */
 public boolean borrowBook(String barcode, String subscriberId,Date date) {
	 try {
		 Subscriber subscriber =  subscriberDAO.getSubscriberByCard(subscriberId);
	 }
	 catch{
		 return "subscriberId Does not exist in the system";	 
	 }
	 if(subscriber.status == AccountFrozen)
		 return "Account is forzen, cant borrow a book while account is frozen!"
	 
	 
     BorrowingRecord borrowRecord = new BorrowingRecord();
     borrowRecord.setRecordID(globalVarRecordID++);
     borrowRecord.setSubscriberID(subscriberId);
     borrowRecord.copyID(barcode);
     borrowRecord.borrowDate(getTime());
     borrowRecord.returnDate(date);
     
     
     return BorrowRecordDAO.addBorrowRecord(borrowRecord); // save new borrow record in database
 }

 /**
  * Processes book returns
  * @param borrowRecordId the unique ID of the borrow record
  * @return true if the return operation is successful, false otherwise
  */
 public boolean returnBook(String subscriberId, String copyId) {
	 // update borrow record 
	 try {
		  BorrowingRecord borrowRecord =fetchBorrowRecordByCopyID(copyId);
	 } catch {
		 return "No borrow record exists with that book ID!"
	 }
	 borrowRecord.returned = true ; 
	 updateBorrowRecord(borrowRecord);
	 
	 
	 
	 //update book quintity in database
	 //send notification  that book is returned
	 BorrowRecord borrowRecord = fetchBorrowRecordByBorrowID(borrowRecordId);
	 
	
	 
	 
     return false; // placeholder return value
 }

 /**
  * Handles loan extension requests
  * @param borrowRecordId the unique ID of the borrow record
  * @return true if the extension is granted, false otherwise
  */
 public Boolean requestLoanExtension(int borrowRecordId , Date newDueDate) {
	 //fetch borrowRecord to see if we can extend
	 try {
	BorrowRecord borrowRecord = fetchBorrowRecordByBorrowID(borrowRecordId);
	 }
	 
	 catch {
		 return "No borrow recrod exists with reocrdID "+ borrowRecordId
	 }
	 
	 if(getTime()- borrowRecord.borrowDate < 1 week ) 	//cant extend until 1 week is remaining
		 
		  if(updateBorrowRecordDate( borrowRecordId, Date newDueDate)) {
			  
			  return "Extended to a new date!"
		  }
	 //error return
     return "Cant extend until 1 week is remaining for return"; // placeholder return value
 }
}


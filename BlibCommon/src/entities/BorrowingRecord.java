package entities;

import java.sql.Date;

public class BorrowingRecord {

	public int getRecordID() {
		return recordID;
	}
	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}
	public int getSubscriberId() {
		return subscriberId;
	}
	public void setSubscriberId(int subscriberId) {
		this.subscriberId = subscriberId;
	}
	public int getCopyId() {
		return copyId;
	}
	public void setCopyId(int copyId) {
		this.copyId = copyId;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public Boolean getIsExtended() {
		return isExtended;
	}
	public void setIsExtended(Boolean isExtended) {
		this.isExtended = isExtended;
	}
	private int recordID;
	private int subscriberId;
	private int copyId;
	private Date borrowDate;
	private Date returnDate;
	private Boolean isExtended;

}
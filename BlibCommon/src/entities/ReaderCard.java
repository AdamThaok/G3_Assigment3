package entities;

import java.util.List;

public class ReaderCard {

	private int cardId;
	private Subscriber subscriber;
	private List<BorrowingRecord> borrowingHistory;
	private List<String> penaltyRecords;
	private List<Reservation> reservationHistory;
	private List<ActivityLogEntry> activityLog;
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public Subscriber getSubscriber() {
		return subscriber;
	}
	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}
	public List<BorrowingRecord> getBorrowingHistory() {
		return borrowingHistory;
	}
	public void setBorrowingHistory(List<BorrowingRecord> borrowingHistory) {
		this.borrowingHistory = borrowingHistory;
	}
	public List<String> getPenaltyRecords() {
		return penaltyRecords;
	}
	public void setPenaltyRecords(List<String> penaltyRecords) {
		this.penaltyRecords = penaltyRecords;
	}
	public List<Reservation> getReservationHistory() {
		return reservationHistory;
	}
	public void setReservationHistory(List<Reservation> reservationHistory) {
		this.reservationHistory = reservationHistory;
	}
	public List<ActivityLogEntry> getActivityLog() {
		return activityLog;
	}
	public void setActivityLog(List<ActivityLogEntry> activityLog) {
		this.activityLog = activityLog;
	}


}
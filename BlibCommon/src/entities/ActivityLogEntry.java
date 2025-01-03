package entities;

public class ActivityLogEntry {

	private Integer activityId;
	private DateTime timestamp;
	private Enum activityType;
	private String details;
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public DateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(DateTime timestamp) {
		this.timestamp = timestamp;
	}
	public Enum getActivityType() {
		return activityType;
	}
	public void setActivityType(Enum activityType) {
		this.activityType = activityType;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
}
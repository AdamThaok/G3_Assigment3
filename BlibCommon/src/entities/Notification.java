package entities;

public class Notification {
	private Integer notificationId;
	private Integer subscriberId;
	private String message;
	private Enum deliveryMethod;
	private Enum status;

	public Integer getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}
	public Integer getSubscriberId() {
		return subscriberId;
	}
	public void setSubscriberId(Integer subscriberId) {
		this.subscriberId = subscriberId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Enum getDeliveryMethod() {
		return deliveryMethod;
	}
	public void setDeliveryMethod(Enum deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	public Enum getStatus() {
		return status;
	}
	public void setStatus(Enum status) {
		this.status = status;
	}


}
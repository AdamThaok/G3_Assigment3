package models;

public class LibrarySubscriber {

    private String name;
    private String subscriptionNumber;
    private SubscriberCard subscriberCard;

    public LibrarySubscriber(String name, String subscriptionNumber, SubscriberCard subscriberCard) {
        this.name = name;
        this.subscriptionNumber = subscriptionNumber;
        this.subscriberCard = subscriberCard;
    }

    public String getName() {
        return name;
    }

    public String getSubscriptionNumber() {
        return subscriptionNumber;
    }

    public SubscriberCard getSubscriberCard() {
        return subscriberCard;
    }
}



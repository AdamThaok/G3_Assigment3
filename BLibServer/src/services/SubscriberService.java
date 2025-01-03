package services;
import entities.*;
import dao.*;
import exceptions.*;
import enums.*;
//========================
//SubscriberService
//========================
public class SubscriberService {
	SubscriberDAO SubscriberDAO;
 /**
  * Retrieves subscriber details
  * @param subscriptionNumber the subscriber's unique card number
  * @return a Subscriber object if found, null otherwise
  */
	public Subscriber getSubscriberByCard(int subscriptionNumber) {
		
	    Subscriber subscriber = SubscriberDAO.getSubscriberByCard(subscriptionNumber);  
	    
	    if (subscriber == null) {
	        throw new SubscriberException(ErrorCode.USER_DOESNT_EXIST);
	    }


	    return subscriber; 
	}

 /**
  * Freezes subscriber accounts
  * @param subscriberId the unique ID of the subscriber
  * @return true if the account was successfully frozen, false otherwise
  */
 public Boolean freezeAccount(int subscriberId) {
	 
	 if(SubscriberDAO.getSubscriberByCard(subscriberId)==null) 	//if user doesnt exist
		 throw new SubscriberException(ErrorCode.USER_DOESNT_EXIST);
	 
	 //freeze account and check if account is valid
	 return SubscriberDAO.updateSubscriberStatus(subscriberId,"frozen");
 }

 /**
  * Registers a new subscriber
  * @param subscriberData the data needed to create a new subscriber
  * @return the new Subscriber object, or null if registration failed
  */
 public Boolean  registerSubscriber(int ID, String name,String phone,String email) {
	 							
	//check if subscriber already registered
	try{SubscriberDAO.getSubscriberByCard(ID);}	
	 catch (SubscriberException e) {
		 
		 }   


     // TODO: Implement subscriber registration logic
	 Subscriber newSub = new Subscriber();
	 newSub.setName(name);
	 newSub.setPhone(phone);;
	 newSub.setEmail(email);
	 newSub.setSubscriberId(ID);;//each subscriber gets its ID depending the order of registration
	 newSub.setStatus("valid");
	 newSub.setPenaltyReason("None");
     return true; // placeholder return value
    
 }
}


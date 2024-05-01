package com.preparation.classes;


interface SocialMedia{
	public void sendMessage(String medium, String message);
}


class WhatsApps implements SocialMedia{

	@Override
	public void sendMessage(String phoneNumber, String message) {
		System.out.println("Sent through whatapp to :"+phoneNumber+" with the message"+message);
	}
	
}

class Email implements SocialMedia{

	@Override
	public void sendMessage(String emailAddress, String message) {
		System.out.println("Sent through Email to :"+emailAddress+" with the message"+message);
	}
}

class MediaFactory{
	public static SocialMedia getSocialMedia(String media) {
		if(media.equalsIgnoreCase("whatsapp")) {
			return new WhatsApps();
		}
		else if(media.equalsIgnoreCase("email")) {
			return new Email();
		}
		return null;
	}
}

class MessageSender {
	
	SocialMedia socialMedia;
	
	MessageSender(String medium) {
	socialMedia = MediaFactory.getSocialMedia(medium);
	}
	
	public void sendMessageToUser(String from, String message) {
		socialMedia.sendMessage(from, message);
	}
	
}

public class DependencyInversionPrinciple {

	public static void main(String[] args) {
		
		MessageSender messageSender = new MessageSender("whatsapp");
		messageSender.sendMessageToUser("9638527410", "Solid principle is completed");
		
	}
	
}

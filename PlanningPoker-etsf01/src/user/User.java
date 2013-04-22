package user;

import poker.CardDeck;


public class User implements User_Interface {
	private String name;
	private String ipAddress; 
	
	public User(String userName){
		this.name = userName;
	}
	
	public User(String userName, String IP)
	{
		this.name = userName; 
		ipAddress = IP; 
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public CardDeck getChoosenCard() {
		// TODO Auto-generated method stub
		return null;
	}
}
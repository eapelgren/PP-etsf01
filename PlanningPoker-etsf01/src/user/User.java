package user;

import poker.Card_Interface;

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
		return null;
	}

	@Override
	public Card_Interface getChoosenCard() {
		// TODO Auto-generated method stub
		return null;
	}
}
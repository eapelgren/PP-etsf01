package user;

public interface UserHandler_Interface {

	public User_Interface[] connectedUsers(); 

	public boolean isConnected(String ip);
	
}
package poker;


public class UserCard{
	private Card card; 
	private User user; 
	
	public UserCard(Card card, User forUser)
	{
		this.card = card; 
		user = forUser; 
	}
	
	public Card getCard()
	{
		return card; 
	}
	
	public User getUser()
	{
		return user; 
	}
}

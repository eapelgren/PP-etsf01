	package poker;

public class QuestionPlayed {
	private Question question; 
	private Card cardAnswered; 
	
	public QuestionPlayed(Question question, Card card)
	{
		this.question = question; 
		this.cardAnswered = card; 
	}
	
	public QuestionPlayed(Question question)
	{
		this.question = question; 
	}
	
	public void setCard(Card card)
	{
		cardAnswered = card;
	}
	
	public Card getCard()
	{
		return cardAnswered; 
	}
	
	public Question getQuestion()
	{
		return question;
	}
}

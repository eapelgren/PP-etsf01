package poker;

public class Question {
	public String question;
	public String questionDescription;


public Question(String question, String questionDescription){
	this.question = question;
	this.questionDescription = questionDescription;
}

	public String getQuestion()
	{
		return question;
	}
	
	public String getDescription()
	{
		return questionDescription;
	}

}


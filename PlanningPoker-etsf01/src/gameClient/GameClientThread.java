package gameClient;

import java.io.BufferedReader;
import java.io.IOException;

import poker.Question;

public class GameClientThread extends Thread{
	BufferedReader fromServer;
	GameClient client;
	
	public GameClientThread(BufferedReader fromServer, GameClient client)
	{
		this.fromServer = fromServer; 
		this.client = client;
	}
	
	public void run()
	{
		while(true)
		{
			try {
				String message = fromServer.readLine();
				if (message != null) {
					handleInputFromServer(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void handleInputFromServer(String input)
	{
		String[] command = input.split(":");
		if (command[0].equals("AllQuestions")){
			allQuestionsAndAnswersFromServer(input);
		}else if(command[0].equals("Answer")){
			answerFromServer(input);
		}else if(command[0].equals("Question")){
			qusetionFromServer(input);
		}
	}
	
	private void qusetionFromServer(String question)
	{
		try{
			String description = fromServer.readLine();
			question = question.substring("Question: ".length());
			if(description.startsWith("Description"))
			{
				description = description.substring("Description: ".length());
				client.setNewQuestion(new Question(question, description));
				client.choosenCard = "notSelected";
			}
		}catch(IOException ex){
			System.out.println("Error when reciving the description");
		}
	}
	
	private void answerFromServer(String answer)
	{
		client.setAnswerOnQuestion(answer.substring("Answer: ".length()));
	}
	
	private void allQuestionsAndAnswersFromServer(String questionsAndAnswers)
	{
		client.setAllQuestionsAndAnswers(questionsAndAnswers.substring("AllQuestions: ".length()));
	}
}

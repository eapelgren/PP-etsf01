package gameServer;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

import poker.Card;
import poker.Question;
import poker.QuestionPlayed;
import poker.User;
import poker.UserCard;

public class GameThread extends Thread {
	
	Socket connection;
	GameServer server;
	BufferedOutputStream toClient;
	BufferedReader fromClient;
	
	public GameThread(Socket connection, GameServer server) {
		this.connection = connection;
		this.server = server;

		try {
			fromClient = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			toClient = new BufferedOutputStream(connection.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Question: question 
	//Description: description
	public void SendQuestion(Question question)
	{
		String questionCommand = "Question: " + question.getQuestion();
		String descriptionCommand = "Description: " + question.getDescription();
		try{
			toClient.write(questionCommand.getBytes());
			toClient.write(descriptionCommand.getBytes());
			toClient.flush();
		}catch(IOException ex)
		{
			System.out.println("Frågan gick inte att skicka");
		}
	}
	
	public void SendResultOnQuestion(ArrayList<UserCard> playedCards)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Answer: ");
		for(UserCard uCard : playedCards)
		{
			sb.append("Player ");
			sb.append(uCard.getUser().getName());
			sb.append(" chose the card ");
			sb.append(uCard.getCard().getValue());
			sb.append("\r\n");
		}
		try{
			toClient.write(sb.toString().getBytes());
		} catch( IOException ex){
			System.out.println("Resultatet kan inte skickas");
		}
	}
	
	public void SendAllQuestionsWithResults()
	{
		ArrayList<QuestionPlayed> al = server.GetAllQuestions();
		StringBuilder sb = new StringBuilder();
		sb.append("AllQuestions:");
		for(QuestionPlayed qp: al)
		{
			sb.append("Result on the question: ");
			sb.append(qp.getQuestion().getQuestion());
			sb.append(" - ");
			sb.append(qp.getCard().getValue());
			sb.append("\r\n");
		}
		try{
			toClient.write(sb.toString().getBytes());
		} catch( IOException ex){
			System.out.println("Hela resultatet kan inte skickas");
		}
	}

	public void run()
	{
		while(true)
		{
			try {
				String message = fromClient.readLine();
				if (message != null) {
					handleInputFromClient(message);
				}
				Thread.yield();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void handleInputFromClient(String input)
	{
		String[] command = input.split(":");

		
		if (command.length > 1 &&command[0].equals("ChoosedCards")){ //kontroll om andra argument i command existerar tillagd av Omar
			choosenCard(command[1]);
		}else if(command.length > 1 && command[0].equals("NewQuestion")){ //kontroll om andra argument i command existerar tillagd av Omar
			newQuestion(command);
		}else if(command[0].equals("StartGame")){
			startGame();
		}else if(command[0].equals("SetupGame")){
			setupGame();
		}else if(command[0].equals("ContinueGame")){
			continueGame();
		}
	}
	
	// ChoosenCard: User - CardValue
	private void choosenCard(String input)
	{
		//String valuesGiven = input.substring("ChoosenCard: ".length()); //varför dela upp argumentet input om den redan är? ->String[] command = input.split(":");
		String valuesGiven = input; //tillagd av omar
		String[] individualValues = valuesGiven.split(" - ");
		Card playedCard = new Card(individualValues[1]);
		User user = new User(individualValues[0]);
		UserCard card = new UserCard(playedCard, user);
		
		server.UserPlayedCard(card);
	}
	
	//NewQuestion: Question : Description
	private void newQuestion(String[] input)
	{
		//String valueGiven = input.substring("NewQuestion: ".length()); //varför dela upp argumentet input om den redan är? ->String[] command = input.split(":");
		String[] valueGiven = input; //tillagd av omar
		//String[] iv = valueGiven.split(" : ");
		
		server.AddNewQuestion(valueGiven[1], valueGiven[2]);
	}
	
	// StartGame
	private void startGame()
	{
		server.StartGame();
	}
	
	// SetupGame
	private void setupGame()
	{
		server.SetupGame();
	}
	
	private void continueGame()
	{
		server.ContinueGame();
	}
}

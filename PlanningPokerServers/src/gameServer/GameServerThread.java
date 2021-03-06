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

public class GameServerThread extends Thread {
	
	Socket connection;
	GameServer server;
	BufferedOutputStream toClient;
	BufferedReader fromClient;
	Boolean readyToStartGame;
	
	public GameServerThread(Socket connection, GameServer server) {
		this.connection = connection;
		this.server = server;
		readyToStartGame = false;

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
		String questionCommand = "Question: " + question.getQuestion() + "\n";
		String descriptionCommand = "Description: " + question.getDescription() + "\n";
		try{
			toClient.write(questionCommand.getBytes());
			toClient.write(descriptionCommand.getBytes());
			toClient.flush();
		}catch(IOException ex)
		{
			System.out.println("The question could not be sent");
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
			System.out.println("The result can not be sent");
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
			if(qp.getCard() != null)
			{
				sb.append(qp.getCard().getValue());
			}
			sb.append("\r\n");
		}
		try{
			toClient.write(sb.toString().getBytes());
		} catch( IOException ex){
			System.out.println("The whole results can not be sent");
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
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void handleInputFromClient(String input)
	{
		String[] command = input.split(":");
		System.out.println("GameThread.java: Incoming command: " +command[0]);
		if(command.length > 0)
		{
			if(command[0].equals("ChoosenCard")){
				choosenCard(command[1]);		
			}else if(command[0].equals("NewQuestion")){
				newQuestion(command[1] + " : " + command[2]);	
			}else if(command[0].trim().equals("StartGame")){
				startGame();
			}else if(command[0].trim().equals("SetupGame")){
				setupGame();
			}else if(command[0].trim().equals("ContinueGame")){
				continueGame();
			} else {
				System.out.println("GameServerThread.java: Command not recognized");
			}
		}
	}
	
	// ChoosedCards: User - CardValue
	private void choosenCard(String input)
	{
		String[] individualValues = input.split(" - ");
		Card playedCard = new Card(individualValues[1].trim());
		User user = new User(individualValues[0]);
		UserCard card = new UserCard(playedCard, user);
		
		server.UserPlayedCard(card);
	}
	
	//NewQuestion: Question : Description
	private void newQuestion(String input)
	{
		String[] values = input.split(" : ");
		
		server.AddNewQuestion(values[0], values[1]);
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

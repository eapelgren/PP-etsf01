package gameClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Observable;

import poker.Card;
import poker.Question;


public class GameClient extends Observable {
	private String userName;
	private Socket socket;
	private OutputStream toServer; 
	private BufferedReader fromServer;
	private Question lastQuestion;
	private String answerOnLastQuestion;
	private String allQuestionsAndAnswers;
	private boolean gameSetup;
	
	public GameClient(String userName, String connectToAddress)
	{
		this.userName = userName; 
		try {
			connectToServer(connectToAddress);
			Thread reciverThread = new GameClientThread(fromServer, this);
			reciverThread.start();
		} catch (UnknownHostException e) {
			System.out.println("Fel serveraddress");
		} catch (IOException e) {
			System.out.println("Exception when trying to connect to server");
		}
	}
	
	private void connectToServer(String ipAddress) throws UnknownHostException, IOException
	{
		socket = new Socket(ipAddress, 31345);
		toServer = socket.getOutputStream();
		fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	public void setNewQuestion(Question question)
	{
		lastQuestion = question;
		setChanged();
		notifyObservers(question);
	}
	public String getAnswerOnLastQuestion()
	{
		return answerOnLastQuestion;
	}
	
	public Question getLastAskedQuestion()
	{
		return lastQuestion;
	}
	
	public void setAnswerOnQuestion(String answer)
	{
		answerOnLastQuestion = answer;
		setChanged();
		notifyObservers(answer);
	}
	
	public void setAllQuestionsAndAnswers(String questionsAndAnswers)
	{
		allQuestionsAndAnswers = questionsAndAnswers;
		setChanged();
		notifyObservers(questionsAndAnswers);
	}
	public String getAllQuestionsAndAnswers()
	{
		return allQuestionsAndAnswers;
	}
	
	public void StartNewGame()
	{
		sendSimpleCommand("StartGame");
	}
	
	public void SetupGame()
	{
		sendSimpleCommand("SetupGame");
	}

	private void sendSimpleCommand(String command) {
		try {
			toServer.write((command + "\n").getBytes());
			toServer.flush();
		} catch (IOException e) {
			System.out.println("Could not send command 'StartGame'");
		}
	}
	
	public void AddNewQuestion(String question, String description)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("NewQuestion: ");
		sb.append(question);
		sb.append(" : ");
		sb.append(description);
		sb.append("\n");
		try {
			System.out.println(sb.toString());
			toServer.write(sb.toString().getBytes());
			toServer.flush();
		} catch (IOException e) {
			System.out.println("Could not send new questiont o server");
		}
		
	}
	
	public void ChooseCard(Card card)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("ChoosenCard: ");
		sb.append(userName);
		sb.append(" - ");
		sb.append(card.getValue());
		sb.append(" \n");
		
		try {
			toServer.write(sb.toString().getBytes());
			toServer.flush();
		} catch (IOException e) {
			System.out.println("Could not send choosen card o server");
		}
		
	}
	
	public void PlayNextQuestion()
	{
		try {
			toServer.write("ContinueGame \n".getBytes());
			toServer.flush();
		} catch (IOException e) {
			System.out.println("Could not send command 'StartGame'");
		}
	}
	
	
	public void closeServerConnection()
	{
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

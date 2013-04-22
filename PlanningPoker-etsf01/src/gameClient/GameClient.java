package gameClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import poker.Card;
import poker.Question;

import chat.ChatServer;

public class GameClient {
	private String userName;
	private Socket socket;
	private OutputStream toServer; 
	private BufferedReader fromServer;
	
	public GameClient(String userName, String connectToAddress)
	{
		this.userName = userName; 
		try {
			connectToServer(connectToAddress);
		} catch (UnknownHostException e) {
			System.out.println("Fel serveraddress");
		} catch (IOException e) {
			System.out.println("Exception when trying to connect to server");
		}
	}
	
	private void connectToServer(String ipAddress) throws UnknownHostException, IOException
	{
		socket = new Socket(ipAddress, ChatServer.CHAT_SERVER_PORT);
		toServer = socket.getOutputStream();
		fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	public Question GetQuestionFromServer()
	{
		return null;
	}
	
	public String GetResultOnQusetion()
	{
		return "";
	}
	
	public String GetAllQuestionsAndResults()
	{
		return "";
	}
	
	public void StartNewGame()
	{
		try {
			toServer.write("StartGame".getBytes());
			toServer.flush();
		} catch (IOException e) {
			System.out.println("Could not send command 'StartGame'");
		}
	}
	
	public void SetupGame()
	{
		try {
			toServer.write("SetupGame".getBytes());
			toServer.flush();
		} catch (IOException e) {
			System.out.println("Could not send command 'StartGame'");
		}
	}
	
	//NewQuestion: Question : Description
	public void AddNewQuestion(String question, String description)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("NewQuestion: ");
		sb.append(question);
		sb.append(" : ");
		sb.append(description);
		
		try {
			toServer.write(sb.toString().getBytes());
			toServer.flush();
		} catch (IOException e) {
			System.out.println("Could not send new questiont o server");
		}
		
	}
	
	// ChoosenCard: User - CardValue
	public void ChooseCard(Card card)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("ChoosenCard: ");
		sb.append(userName);
		sb.append(" - ");
		sb.append(card.getValue());
		
		try {
			toServer.write(sb.toString().getBytes());
			toServer.flush();
		} catch (IOException e) {
			System.out.println("Could not send choosen card o server");
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

package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	private String userName;
	private Socket socket;
	private OutputStream outStream;//skickar till server 
	private BufferedReader inStream;//data fr�n server
	
	public ChatClient(String userName)
	{
		this.userName = userName;
		
	}
	
	public void connectToServer(String ipAddress) throws UnknownHostException, IOException
	{
		socket = new Socket(ipAddress, 31346);
		outStream = socket.getOutputStream();
		inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	public void sendMessage(String message)
	{
		if(!message.endsWith("\r\n"))
		{
			message = message + "\r\n";
		}
		String stringToSend = userName + ": " + message;
		try {
			System.out.println("Sends the message to the server: " + stringToSend);
			outStream.write(stringToSend.getBytes());
			outStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getMessage()
	{
		try {
			return inStream.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
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

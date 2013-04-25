package chat;

import gui.ChatWindow;

import java.io.IOException;
import java.net.UnknownHostException;

public class ChatProgram {
	 
	
	public ChatProgram(String userName, String host)
	{
		ChatClient client = new ChatClient(userName);
		try {
			client.connectToServer(host);
			ChatWindow window = new ChatWindow();
			ChatWindowThread putMessagesInWindow = new ChatWindowThread(client, 
					ChatWindowThread.WRITE_TO_WINDOW, window);
			ChatWindowThread sendMessageToOtherClients = new ChatWindowThread(client, 
					ChatWindowThread.SEND_TO_SERVER, window);
			
			
			putMessagesInWindow.start();
			sendMessageToOtherClients.start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	}

	


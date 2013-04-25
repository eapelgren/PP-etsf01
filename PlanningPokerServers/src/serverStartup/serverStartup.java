package serverStartup;

import java.io.IOException;

import gameServer.GameServer;
import chat.ChatServer;

public class serverStartup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new GameServer();
			new ChatServer();
		} catch (IOException e) {
			System.out.println("Servrar kunde inte startas");
		}
		
	}

}

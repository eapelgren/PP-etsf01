package gameServer;

import java.io.IOException;

import poker.Card;
import user.User;

public class Test {

	private static final String Anna = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			GameServer gameServer = new GameServer();
			gameServer.SetupGame();
			gameServer.StartGame();
			Card c = new Card (8);
			User u = new User ("Anna", "localhost");
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

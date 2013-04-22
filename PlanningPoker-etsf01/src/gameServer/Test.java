package gameServer;

import java.io.IOException;

import poker.Card;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			GameServer gameServer = new GameServer();
			gameServer.SetupGame();
			gameServer.StartGame();
			Card c = new Card (8);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

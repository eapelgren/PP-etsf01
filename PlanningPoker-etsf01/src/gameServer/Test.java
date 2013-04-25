package gameServer;

import gameClient.GameClient;

import java.io.IOException;

import javax.swing.JOptionPane;

import chat.ChatProgram;

import poker.Card;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GameServer gameServer;
		try {
			gameServer = new GameServer();
			gameServer.SetupGame();
			
			/*telnet client test
			telnet localhost:31345
			command 'NewQuestion: Question : Description' //tested confirmed working
			command 'ChoosenCard: User - CardValue' //tested confirmed working
			command 'SetupGame' //tested confirmed working
			command 'StartGame' //tested confirmed working, unsure about the returned results:
			Doesn't poll the question since 'playersAggreed' is set to false in Row 77 in GameServer.java
			
			
			
			
			*/
		} catch (IOException e) {
			System.out.println("Exception : " + e.getMessage());
		}
	}

}

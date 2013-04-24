package gameServer;

import java.io.IOException;

public class GameServerThread extends Thread {
	public GameServerThread() {
		
	}
		
		public void run() {
			GameServer gameServer;
			try {
				gameServer = new GameServer();
				gameServer.SetupGame();
			} catch (IOException e) {
				System.out.println("Exception : " + e.getMessage());
			}
			
		}
	}
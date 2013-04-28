package gameServer;


import java.io.IOException;

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
			command 'ChoosedCards: User - 0' //tested confirmed working
			command 'StartGame' //tested confirmed working
			command 'SetupGame' //tested confirmed working
			
			

			*/
		} catch (IOException e) {
			System.out.println("Exception : " + e.getMessage());
		}
	}

}

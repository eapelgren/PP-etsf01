package server;

import java.io.IOException;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			KnockKnockServer server = new KnockKnockServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

package chat;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new  Scanner (System.in);
		String name = "" + scan.next();
		
		new ChatProgram(name);
		
		
	}

}

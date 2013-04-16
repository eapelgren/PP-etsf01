package chat;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatServerThread extends Thread {
	Socket connection;
	ChatServer server;
	BufferedOutputStream toClient;
	BufferedReader fromClient;

	public ChatServerThread(Socket connection, ChatServer server) {
		this.connection = connection;
		this.server = server;

		try {
			fromClient = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			toClient = new BufferedOutputStream(connection.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {

		while (true) {
			try {
				String message = fromClient.readLine();
				if (message != null) {
					server.sendMessageToClients(message);
				}
				Thread.yield();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void killThread() {
		try {
			this.join(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void sendMessageToClient(String message) {
		try {
			toClient.write(message.getBytes());
			toClient.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

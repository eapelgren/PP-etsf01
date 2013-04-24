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
		GameServerThread gs = new GameServerThread();
		gs.start();

		String username = JOptionPane.showInputDialog("username");
		String host = JOptionPane.showInputDialog("host");
		GameClient gc = new GameClient(username, host);
	}

}

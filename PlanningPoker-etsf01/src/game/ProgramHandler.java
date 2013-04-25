package game;

import java.io.IOException;
import java.net.UnknownHostException;

import chat.ChatClient;
import chat.ChatProgram;
import chat.ChatServer;

import gameClient.GameClient;
import gameServer.GameServer;
import gui.FrameHandler;
import gui.GameFrame;
import gui.LoginFrame;
import gui.LoginPane;
import gui.NewQuestionFrame;

public class ProgramHandler {
	private FrameHandler fHandler;
	private GameClient gameClient;
	private ChatProgram chatProgram; 
	
	public ProgramHandler()
	{
		fHandler = new FrameHandler(null, null, null);
	}
	
	public void startLoginScreen()
	{
		fHandler.frame = new LoginFrame(getFrameHandler(), this);
		fHandler.frame.setVisible(true);
	}
	
	public void connectToGame(String userName, String ip)
	{
		GameClient game = new GameClient(userName, ip);
		chatProgram = new ChatProgram(userName, ip);
		fHandler.frame3 = new GameFrame();
		fHandler.frame3.setVisible(true);
		fHandler.frame.setVisible(false);
		SystemToGuiHandler guiLink = new SystemToGuiHandler(fHandler.frame3);
		
		game.addObserver(guiLink);
	}
	
	public void createNewGame(String userName) throws IllegalAccessException
	{
		try {
			new GameServer();
			new ChatServer();
		} catch (IOException e) {
			System.out.println("Kunde inte starta servern");
			System.exit(-1);
		}
		gameClient = new GameClient(userName, "localhost");
		chatProgram = new ChatProgram(userName, "localhost");
		fHandler.frame.setVisible(false);
		fHandler.frame2 = new NewQuestionFrame(getGameClient(), getFrameHandler());
		fHandler.frame2.setVisible(true);
	}
	
	private FrameHandler getFrameHandler()
	{
		if(fHandler == null)
			fHandler = new FrameHandler(null, null, null);
		return fHandler;
	}
	
	private GameClient getGameClient() throws IllegalAccessException
	{
		if(gameClient == null)
			throw new IllegalAccessException("No game client started yet");
		return gameClient;
	}
}

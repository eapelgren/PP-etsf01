package game;

import chat.ChatProgram;
import gameClient.GameClient;
import gui.FrameHandler;
import gui.GameFrame;
import gui.LoginFrame;
import gui.NewQuestionFrame;

public class ProgramHandler {
	private FrameHandler fHandler;
	private GameClient gameClient;
	private String uName;
	
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
		gameClient = new GameClient(userName, ip, fHandler);
		new ChatProgram(userName, ip);
		fHandler.frame3 = new GameFrame(false, gameClient);
		fHandler.frame3.setVisible(true);
		fHandler.frame.setVisible(false);
		SystemToGuiHandler guiLink = new SystemToGuiHandler(fHandler.frame3);
		
		gameClient.addObserver(guiLink);
	}
	
	public void createNewGame(String userName) throws IllegalAccessException
	{
		uName = userName; 
		gameClient = new GameClient(userName, "localhost", fHandler);
		fHandler.frame.setVisible(false);
		fHandler.frame2 = new NewQuestionFrame(getGameClient(), getFrameHandler(), this);
		fHandler.frame3 = new GameFrame(true, gameClient);
		fHandler.frame2.setVisible(true);
		fHandler.frame3.setVisible(false);
	}
	
	public void startModeratorGame() throws IllegalAccessException
	{
		new ChatProgram(uName, "localhost");
		
		fHandler.frame3.setVisible(true);
		fHandler.frame2.setVisible(false);
		SystemToGuiHandler guiLink = new SystemToGuiHandler(fHandler.frame3);
		
		gameClient.addObserver(guiLink);
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

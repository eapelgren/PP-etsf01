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
	private ChatProgram chatProgram; 
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
		GameClient game = new GameClient(userName, ip);
		chatProgram = new ChatProgram(userName, ip);
		fHandler.frame3 = new GameFrame(false, game);
		fHandler.frame3.setVisible(true);
		fHandler.frame.setVisible(false);
		SystemToGuiHandler guiLink = new SystemToGuiHandler(fHandler.frame3);
		
		game.addObserver(guiLink);
	}
	
	public void createNewGame(String userName) throws IllegalAccessException
	{
		uName = userName; 
		gameClient = new GameClient(userName, "localhost");
		fHandler.frame.setVisible(false);
		fHandler.frame2 = new NewQuestionFrame(getGameClient(), getFrameHandler(), this);
		fHandler.frame2.setVisible(true);
	}
	
	public void startModeratorGame() throws IllegalAccessException
	{
		getGameClient().StartNewGame();
		connectToGame(uName, "localhost");
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

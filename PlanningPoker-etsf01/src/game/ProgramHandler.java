package game;

import gameClient.GameClient;
import gui.FrameHandler;
import gui.GameFrame;
import gui.LoginFrame;
import gui.LoginPane;
import gui.NewQuestionFrame;

public class ProgramHandler {
	private FrameHandler fHandler;
	private GameClient gameClient;
	
	public void startLoginScreen()
	{
		fHandler.frame = new LoginFrame(getFrameHandler(), this);
	}
	
	public void connectToGame(String userName, String ip)
	{
		GameClient game = new GameClient(userName, ip);
		fHandler.frame3 = new GameFrame();
		SystemToGuiHandler guiLink = new SystemToGuiHandler(fHandler.frame3);
		
		game.addObserver(guiLink);
	}
	
	public void createNewGame() throws IllegalAccessException
	{
		fHandler.frame2 = new NewQuestionFrame(getGameClient(), getFrameHandler());
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

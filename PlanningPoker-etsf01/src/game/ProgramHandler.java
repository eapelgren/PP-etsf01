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
		fHandler.frame3 = new GameFrame(false);
		fHandler.frame3.setVisible(true);
		fHandler.frame.setVisible(false);
		SystemToGuiHandler guiLink = new SystemToGuiHandler(fHandler.frame3);
		
		game.addObserver(guiLink);
	}
	
	public void createNewGame(String userName) throws IllegalAccessException
	{
		gameClient = new GameClient(userName, "localhost");
		chatProgram = new ChatProgram(userName, "localhost");
		fHandler.frame.setVisible(false);
		fHandler.frame2 = new NewQuestionFrame(getGameClient(), getFrameHandler());
		fHandler.frame2.setVisible(true);
	}
	
	public void startModeratorGame()
	{
		gameClient.StartNewGame();
		frameHandler.frame2.setVisible(false);
		GameFrame gameFrame = new GameFrame();
		frameHandler.setGameFrame(gameFrame);
		frameHandler.frame3.setVisible(true);
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

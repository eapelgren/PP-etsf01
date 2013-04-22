package gui;

public class FrameHandler {
	public LoginFrame frame;
	public NewQuestionFrame frame2;
	public GameFrame frame3;
	public FrameHandler(LoginFrame login, NewQuestionFrame question, GameFrame game){
		frame = login; 
		frame2 = question; 
		frame3 = game; 
	}
	
}

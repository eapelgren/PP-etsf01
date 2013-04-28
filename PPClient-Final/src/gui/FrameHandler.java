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
	public void setLoginFrame(LoginFrame frame){
		this.frame = frame;
	}
	public void setNewQuestionFrame(NewQuestionFrame frame){
		this.frame2 = frame;
	}
	public void setGameFrame(GameFrame frame){
		this.frame3 = frame;
	}
}

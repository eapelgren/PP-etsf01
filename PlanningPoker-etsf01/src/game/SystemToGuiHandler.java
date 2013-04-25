package game;

import java.util.Observable;
import java.util.Observer;

import poker.Question;
import gui.GameFrame;
import gui.GamePane;
import gui.ResultPane;

public class SystemToGuiHandler implements Observer {
	
	private GamePane questionView; 
	private ResultPane resultView;
	
	public SystemToGuiHandler(GameFrame gameView)
	{
		questionView = gameView.getGamePane();
		resultView = gameView.getResultPane();
	}
	

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg1 instanceof Question)
		{
			questionView.loadQuestion((Question)arg1);
		}
		if(arg1 instanceof String)
		{
			String result = (String)arg1; 
			if(result.startsWith("Player"))
			{
				questionView.setResultOfLastQuestion(result);
			}else if(result.startsWith("Result"))
			{
				resultView.setResultOfGameSoFar(result);
			}
		}
	}
}

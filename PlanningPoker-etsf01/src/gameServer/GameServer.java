package gameServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import poker.Card;
import poker.Question;
import poker.QuestionPlayed;
import poker.UserCard;

public class GameServer {
	
	private ServerSocket socket;
	private ArrayList<GameThread> gameClients;
	private Queue<Question> gameQuestions; 
	private ArrayList<QuestionPlayed> allGameQuestions; 
	private boolean gameStarted; 
	public static int GAME_SERVER_PORT = 31345;
	private boolean playersAggreed;
	private Question lastQuestion;
	private ArrayList<UserCard> playedCards; 
	
	public GameServer() throws IOException
	{
		socket = new ServerSocket(GAME_SERVER_PORT);
		gameClients = new ArrayList<GameThread>();
		
		//initsialisering av variabler - tillagd av omar
		allGameQuestions = new ArrayList<QuestionPlayed>(); 
		gameQuestions = new LinkedList<Question>();
		playedCards = new ArrayList<UserCard>();
		lastQuestion = new Question("No question", "No question");
	}
	// Allows other users connect to the game
	public void SetupGame()
	{
		while (!gameStarted) {
			try {
				Socket connection = socket.accept();
				GameThread chatThread = new GameThread(connection,
						this);
				gameClients.add(chatThread);
				chatThread.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Starts the game
	public void StartGame()
	{
		gameStarted = true;
		ContinueGame();
	}
	
	// Gives the next question in the game, 
	// if there is one, if not it ends the game
	public void ContinueGame()
	{
		if(!gameQuestions.isEmpty()){
			giveQuestion();
		}
		else {
			System.out.print("end game");
			EndGame();
		}
	}

	private void giveQuestion() {
		if(playersAggreed)
			lastQuestion = gameQuestions.poll();
		for(GameThread player : gameClients)
		{
			player.SendQuestion(lastQuestion);
		}
	}
	
	public void EndGame(){
		for(GameThread player : gameClients)
		{
			player.SendAllQuestionsWithResults();
		}
	}
	
	public void UserPlayedCard(UserCard card)
	{
		playedCards.add(card);
		
		if(playedCards.size() == gameClients.size())
		{
			compareResultsForQuestion();
		}
	}
	
	public void ReportResultOnQuestion()
	{
		for(GameThread player : gameClients)
		{
			player.SendResultOnQuestion(playedCards);
		}
	}
	
	private void compareResultsForQuestion()
	{
		Card firstCard = null;
		playersAggreed = true; 
		for(UserCard uCard : playedCards)
		{
			if(firstCard == null){
				firstCard = uCard.getCard();
			}
			else  {
				if(firstCard.getValue() != uCard.getCard().getValue())
					playersAggreed = false; 
			}
		}
	}
	
	public ArrayList<QuestionPlayed> GetAllQuestions()
	{
		return allGameQuestions;
	}
	
	public void AddNewQuestion(String question, String description)
	{
		Question newQuestion = new Question(question, description);
		allGameQuestions.add(new QuestionPlayed(newQuestion));
		gameQuestions.offer(newQuestion);
	}
	
}

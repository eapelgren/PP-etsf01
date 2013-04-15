package poker;

import gui.Frame;

import java.awt.EventQueue;
import java.util.ArrayList;

public class TestServer {
	private Question q1;
	private Question q2;
	private Question q3;
	private ArrayList qList;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
					TestServer testServer = new TestServer();
					frame.gamePane.loadQuestion(testServer.getQuestion());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public TestServer(){
		q1 = new Question("RUBRIK FR�GA 1","DETTA �R FR�GA 1");
		q2 = new Question("RUBRIK FR�GA 2","DETTA �R FR�GA 2");
		q3 = new Question("RUBRIK FR�GA 3","DETTA �R FR�GA 3");
		qList = new ArrayList<Question>();
		qList.add(q1);
	
	}
	
	
	public Question getQuestion(){
		return q1;
	}
}

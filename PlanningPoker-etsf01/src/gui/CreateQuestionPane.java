package gui;

import game.ProgramHandler;
import gameClient.GameClient;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import poker.Question;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateQuestionPane extends JPanel {
		private JEditorPane editQuestion;
		private JEditorPane editQuestionDescription;
		private GameClient gameClient;
		private JButton startGameBtn;
		private ProgramHandler pHandler;
	/**
	 * Create the panel.
	 */
	public CreateQuestionPane(GameClient client, FrameHandler handler, ProgramHandler pHandler) {
		setLayout(null);
		this.pHandler = pHandler; 
		this.gameClient = client;
		editQuestion = new JEditorPane();
		editQuestion.setBounds(60, 135, 166, 199);
		add(editQuestion);
		
		editQuestionDescription = new JEditorPane();
		editQuestionDescription.setBounds(303, 135, 166, 199);
		add(editQuestionDescription);
		
		JButton btnNyFrga = new JButton("Save/New question");
		btnNyFrga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Question question = createQuestion();
				gameClient.AddNewQuestion(question.question, question.questionDescription);
			}
		});
		
		btnNyFrga.setBounds(60, 380, 126, 23);
		add(btnNyFrga);
		
		JButton btnKlar = new JButton("Save/open Server");
		btnKlar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Question question = createQuestion();
				gameClient.AddNewQuestion(question.question, question.questionDescription);
				startGameBtn.setEnabled(true);
			}
		});
		
		startGameBtn = new JButton("Start the Game");
		startGameBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameClient.StartNewGame();
				startGame();
			}
		});
		startGameBtn.setEnabled(false);
		startGameBtn.setBounds(303, 414, 177, 23);
		add(startGameBtn);
		btnKlar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnKlar.setBounds(303, 380, 177, 23);
		add(btnKlar);
		
		JLabel lblSkrivInNy = new JLabel("Enter a new question");
		lblSkrivInNy.setBounds(60, 88, 106, 23);
		add(lblSkrivInNy);
		
		JLabel lblBeskrivningAvFrga = new JLabel("Description of question");
		lblBeskrivningAvFrga.setBounds(303, 88, 117, 23);
		add(lblBeskrivningAvFrga);
		
		JLabel lblSkapaFrgor = new JLabel("Create a question");
		lblSkapaFrgor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSkapaFrgor.setBounds(60, 11, 126, 23);
		add(lblSkapaFrgor);
	}
	public Question createQuestion(){
		
		Question returnQuestion = new Question(editQuestion.getText(), editQuestionDescription.getText());
		editQuestion.setText("");
		editQuestionDescription.setText("");
		return returnQuestion;
		}
	
	private void startGame()
	{
		try {
			pHandler.startModeratorGame();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

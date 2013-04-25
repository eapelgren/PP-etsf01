package gui;

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
		private FrameHandler frameHandler;
		private JButton startGameBtn;
	/**
	 * Create the panel.
	 */
	public CreateQuestionPane(GameClient client, FrameHandler handler) {
		setLayout(null);
		this.frameHandler = handler;
		this.gameClient = client;
		editQuestion = new JEditorPane();
		editQuestion.setBounds(60, 135, 166, 199);
		add(editQuestion);
		
		editQuestionDescription = new JEditorPane();
		editQuestionDescription.setBounds(303, 135, 166, 199);
		add(editQuestionDescription);
		
		JButton btnNyFrga = new JButton("Spara/Ny fr\u00E5ga");
		btnNyFrga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Question question = createQuestion();
				gameClient.AddNewQuestion(question.question, question.questionDescription);
				
			}
		});
		btnNyFrga.setBounds(60, 380, 126, 23);
		add(btnNyFrga);
		
		JButton btnKlar = new JButton("Spara/\u00D6ppna Server");
		btnKlar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Question question = createQuestion();
				gameClient.AddNewQuestion(question.question, question.questionDescription);
				gameClient.SetupGame();
				startGameBtn.setEnabled(true);
			}
		});
		btnKlar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnKlar.setBounds(303, 380, 177, 23);
		add(btnKlar);
		
		JLabel lblSkrivInNy = new JLabel("Skriv in ny fr\u00E5ga");
		lblSkrivInNy.setBounds(60, 88, 106, 23);
		add(lblSkrivInNy);
		
		JLabel lblBeskrivningAvFrga = new JLabel("Beskrivning av fr\u00E5ga");
		lblBeskrivningAvFrga.setBounds(303, 88, 117, 23);
		add(lblBeskrivningAvFrga);
		
		JLabel lblSkapaFrgor = new JLabel("Skapa fr\u00E5ga");
		lblSkapaFrgor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSkapaFrgor.setBounds(60, 11, 126, 23);
		add(lblSkapaFrgor);
		
		startGameBtn = new JButton("Starta Spel");
		startGameBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
		
			
			}
		});
		startGameBtn.setEnabled(false);
		startGameBtn.setBounds(303, 414, 177, 23);
		add(startGameBtn);

	}
	public Question createQuestion(){
		
		Question returnQuestion = new Question(editQuestion.getText(), editQuestionDescription.getText());
		editQuestion.setText("");
		editQuestionDescription.setText("");
		return returnQuestion;
		}
}

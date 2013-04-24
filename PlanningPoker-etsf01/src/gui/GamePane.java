package gui;
import game.ProgramHandler;
import gameClient.GameClient;

import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;

import poker.Card;
import poker.Question;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;


public class GamePane extends JPanel {
	private JLabel questionLabel;
	private GameClient gameClient;
	private ProgramHandler pHandler;
	/**
	 * Create the panel.
	 */
	public GamePane() {
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Planning Poker");
		lblNewJgoodiesLabel.setBounds(10, 11, 143, 25);
		add(lblNewJgoodiesLabel);
		
		questionLabel = DefaultComponentFactory.getInstance().createLabel("Beskrvining av Fr\u00E5ga");
		questionLabel.setBounds(54, 47, 154, 39);
		add(questionLabel);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				gameClient.ChooseCard(new Card (1));
			}
		});
		btnNewButton.setBounds(54, 395, 49, 39);
		add(btnNewButton);
		
		JButton button = new JButton("2");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameClient.ChooseCard(new Card (2));
			}
		});
		button.setBounds(101, 395, 49, 39);
		add(button);
		
		JButton button_1 = new JButton("3");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameClient.ChooseCard(new Card (3));
			}
		});
		button_1.setBounds(150, 395, 49, 39);
		add(button_1);
		
		JButton button_2 = new JButton("5");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameClient.ChooseCard(new Card (5));
			}
		});
		button_2.setBounds(199, 395, 49, 39);
		add(button_2);
		
		JButton button_3 = new JButton("13");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameClient.ChooseCard(new Card (13));
			}
		});
		button_3.setBounds(54, 435, 49, 39);
		add(button_3);
		
		JButton button_4 = new JButton("21");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameClient.ChooseCard(new Card (21));
			}
		});
		button_4.setBounds(101, 435, 49, 39);
		add(button_4);
		
		JButton button_5 = new JButton("34");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameClient.ChooseCard(new Card (34));
			}
		});
		button_5.setBounds(150, 435, 49, 39);
		add(button_5);
		
		JButton button_6 = new JButton("55");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameClient.ChooseCard(new Card (55));
			}
		});
		button_6.setBounds(199, 435, 49, 39);
		add(button_6);
		
		JButton button_7 = new JButton("8");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameClient.ChooseCard(new Card (8));
			}
		});
		button_7.setBounds(246, 395, 49, 39);
		add(button_7);
		
		JButton button_8 = new JButton("89");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gameClient.ChooseCard(new Card (89));
			}
		});
		button_8.setBounds(246, 435, 49, 39);
		add(button_8);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Deltagare");
		lblNewJgoodiesLabel_2.setBounds(333, 59, 92, 14);
		add(lblNewJgoodiesLabel_2);
		
		JList list = new JList();
		list.setBounds(333, 97, 124, 220);
		add(list);
		
		JButton btnNewButton_1 = new JButton("Se resultat");
		btnNewButton_1.setBounds(341, 351, 104, 23);
		add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 95, 214, 267);
		add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
	

	}
	
	
	public void loadQuestion(Question question){
		questionLabel.setText(question.question);
		questionDescriptionTF.setText(question.questionDescription);
	}
}

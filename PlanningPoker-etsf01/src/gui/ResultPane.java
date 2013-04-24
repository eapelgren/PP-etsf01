package gui;
import gameClient.GameClient;

import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ResultPane extends JPanel {

	private DefaultListModel listModel;
	private GameClient gameClient;
	private JTextPane textResultPane;
	/**
	 * Create the panel.
	 */
	public ResultPane() {
		setLayout(null);
		
		JLabel lblPlanningPoker = DefaultComponentFactory.getInstance().createLabel("Planning Poker");
		lblPlanningPoker.setBounds(10, 11, 92, 14);
		add(lblPlanningPoker);
		
		
		listModel = new DefaultListModel();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 413, 357);
		add(scrollPane);
		
		textResultPane = new JTextPane();
		scrollPane.setViewportView(textResultPane);
		
		JButton btnResult = new JButton("Se Resultat");
		btnResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			gameClient.getAllQuestionsAndAnswers();
			
			}
		});
		btnResult.setEnabled(false);
		btnResult.setBounds(10, 419, 89, 23);
		add(btnResult);
	}
	
	public void setResultOfLastQuestion(String result)
	{
		
	}
	
	public void setResultOfGameSoFar(String result)
	{
		
	}
}

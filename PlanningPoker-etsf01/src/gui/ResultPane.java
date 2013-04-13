package gui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;


public class ResultPane extends JPanel {

	private DefaultListModel listModel;
	
	/**
	 * Create the panel.
	 */
	public ResultPane() {
		setLayout(null);
		
		JLabel lblPlanningPoker = DefaultComponentFactory.getInstance().createLabel("Planning Poker");
		lblPlanningPoker.setBounds(10, 11, 92, 14);
		add(lblPlanningPoker);
		
		JEditorPane editorPaneD1 = new JEditorPane();
		editorPaneD1.setBounds(362, 49, 63, 20);
		add(editorPaneD1);
		
		JEditorPane editorPaneD2 = new JEditorPane();
		editorPaneD2.setBounds(362, 80, 63, 20);
		add(editorPaneD2);
		
		JEditorPane editorPaneD3 = new JEditorPane();
		editorPaneD3.setBounds(362, 111, 63, 20);
		add(editorPaneD3);
		
		JEditorPane editorPaneD4 = new JEditorPane();
		editorPaneD4.setBounds(362, 143, 63, 20);
		add(editorPaneD4);
		
		JEditorPane editorPaneD5 = new JEditorPane();
		editorPaneD5.setBounds(362, 173, 63, 20);
		add(editorPaneD5);
		
		JEditorPane editorPaneD6 = new JEditorPane();
		editorPaneD6.setBounds(362, 204, 63, 20);
		add(editorPaneD6);
		
		JEditorPane editorPaneD7 = new JEditorPane();
		editorPaneD7.setBounds(362, 235, 63, 20);
		add(editorPaneD7);
		
		JEditorPane editorPaneD8 = new JEditorPane();
		editorPaneD8.setBounds(362, 266, 63, 20);
		add(editorPaneD8);
		
		JLabel LabelD2 = DefaultComponentFactory.getInstance().createLabel("Deltagare 2");
		LabelD2.setBounds(260, 86, 92, 14);
		add(LabelD2);
		
		JLabel LabelD3 = DefaultComponentFactory.getInstance().createLabel("Deltagare 3");
		LabelD3.setBounds(260, 117, 92, 14);
		add(LabelD3);
		
		JLabel LabelD4 = DefaultComponentFactory.getInstance().createLabel("Deltagare 4");
		LabelD4.setBounds(260, 149, 92, 14);
		add(LabelD4);
		
		JLabel LabelD5 = DefaultComponentFactory.getInstance().createLabel("Deltagare 5");
		LabelD5.setBounds(260, 179, 92, 14);
		add(LabelD5);
		
		JLabel LabelD6 = DefaultComponentFactory.getInstance().createLabel("Deltagare 6");
		LabelD6.setBounds(260, 210, 92, 14);
		add(LabelD6);
		
		JLabel LabelD7 = DefaultComponentFactory.getInstance().createLabel("Deltagare 7");
		LabelD7.setBounds(260, 241, 92, 14);
		add(LabelD7);
		
		JLabel LabelD8 = DefaultComponentFactory.getInstance().createLabel("Deltagare 8");
		LabelD8.setBounds(260, 272, 92, 14);
		add(LabelD8);
		
		JLabel lblResultat = DefaultComponentFactory.getInstance().createLabel("Resultat f\u00F6r fr\u00E5ga X");
		lblResultat.setBounds(260, 24, 119, 14);
		add(lblResultat);
		
		JEditorPane editorPaneD9 = new JEditorPane();
		editorPaneD9.setBounds(362, 297, 63, 20);
		add(editorPaneD9);
		
		JEditorPane editorPaneD10 = new JEditorPane();
		editorPaneD10.setBounds(362, 328, 63, 20);
		add(editorPaneD10);
		
		JLabel LabelD9 = DefaultComponentFactory.getInstance().createLabel("Deltagare 9");
		LabelD9.setBounds(260, 303, 92, 14);
		add(LabelD9);
		
		JLabel LabelD10 = DefaultComponentFactory.getInstance().createLabel("Deltagare 10");
		LabelD10.setBounds(260, 334, 92, 14);
		add(LabelD10);
		
		JLabel LabelD1 = DefaultComponentFactory.getInstance().createLabel("Deltagare 1");
		LabelD1.setBounds(260, 55, 92, 14);
		add(LabelD1);
		
		
		listModel = new DefaultListModel();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 220, 361);
		JList questionList = new JList(listModel);
		questionList.setBounds(10, 49, 220, 361);
		add(scrollPane);
		scrollPane.setViewportView(questionList);
		
		JButton btnSpelaOm = new JButton("Spela Om");
		btnSpelaOm.setEnabled(false);
		btnSpelaOm.setBounds(260, 387, 89, 23);
		add(btnSpelaOm);
		

	}
}

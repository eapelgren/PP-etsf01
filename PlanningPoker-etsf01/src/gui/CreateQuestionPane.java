package gui;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class CreateQuestionPane extends JPanel {

	/**
	 * Create the panel.
	 */
	public CreateQuestionPane() {
		setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(60, 135, 166, 199);
		add(editorPane);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(303, 135, 166, 199);
		add(editorPane_1);
		
		JButton btnNyFrga = new JButton("Spara/Ny fr\u00E5ga");
		btnNyFrga.setBounds(60, 380, 126, 23);
		add(btnNyFrga);
		
		JButton btnKlar = new JButton("Spara/Starta nytt spel");
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

	}
}

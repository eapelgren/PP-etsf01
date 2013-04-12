import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;


public class GamePane extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public GamePane() {
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Planning Poker");
		lblNewJgoodiesLabel.setBounds(10, 11, 143, 25);
		add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Beskrvining av Fr\u00E5ga");
		lblNewJgoodiesLabel_1.setBounds(54, 47, 154, 39);
		add(lblNewJgoodiesLabel_1);
		
		textField = new JTextField();
		textField.setBounds(54, 97, 241, 220);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.setBounds(54, 395, 49, 39);
		add(btnNewButton);
		
		JButton button = new JButton("2");
		button.setBounds(101, 395, 49, 39);
		add(button);
		
		JButton button_1 = new JButton("3");
		button_1.setBounds(150, 395, 49, 39);
		add(button_1);
		
		JButton button_2 = new JButton("5");
		button_2.setBounds(199, 395, 49, 39);
		add(button_2);
		
		JButton button_3 = new JButton("13");
		button_3.setBounds(54, 435, 49, 39);
		add(button_3);
		
		JButton button_4 = new JButton("21");
		button_4.setBounds(101, 435, 49, 39);
		add(button_4);
		
		JButton button_5 = new JButton("34");
		button_5.setBounds(150, 435, 49, 39);
		add(button_5);
		
		JButton button_6 = new JButton("55");
		button_6.setBounds(199, 435, 49, 39);
		add(button_6);
		
		JButton button_7 = new JButton("8");
		button_7.setBounds(246, 395, 49, 39);
		add(button_7);
		
		JButton button_8 = new JButton("89");
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

	}
}

package gui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LoginPane extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public LoginPane() {
		setLayout(null);
		
		JLabel lblLogin = DefaultComponentFactory.getInstance().createLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogin.setBounds(10, 11, 120, 41);
		add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(101, 63, 154, 20);
		add(textField);
		textField.setColumns(10);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(101, 112, 154, 20);
		add(editorPane);
		
		JLabel lblNamn = DefaultComponentFactory.getInstance().createLabel("Namn");
		lblNamn.setBounds(10, 66, 92, 14);
		add(lblNamn);
		
		JLabel lblIp = DefaultComponentFactory.getInstance().createLabel("IP(xx.xx.xx.xx)");
		lblIp.setBounds(10, 112, 92, 14);
		add(lblIp);
		
		JButton btnLogin = new JButton("Login");
		add(btnLogin);
		btnLogin.setBounds(10, 175, 89, 23);
		
		JButton btnSkapaNyttSpel = new JButton("Skapa nytt spel");
		btnSkapaNyttSpel.setBounds(166, 175, 126, 23);
		add(btnSkapaNyttSpel);
		btnLogin.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			if(isConnected()){
			}
		}
		});

		
		
	}
	public boolean isConnected(){
		return true;
		
	}
}

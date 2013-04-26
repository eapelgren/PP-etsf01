package gui;
import game.ProgramHandler;
import gameClient.GameClient;

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
	public String name;
	public String ip;
	private JEditorPane editorPaneName; 
	private JEditorPane editorPaneIp;
	private ProgramHandler pHandler;
	
	/**
	 * Create the panel.
	 */
	public LoginPane(ProgramHandler pHandler) {
		setLayout(null);
		this.pHandler = pHandler;
		JLabel lblLogin = DefaultComponentFactory.getInstance().createLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogin.setBounds(10, 11, 120, 41);
		add(lblLogin);
		
		this.editorPaneName = new JEditorPane();
		editorPaneName.setBounds(101, 63, 154, 20);
		add(editorPaneName);
		
		this.editorPaneIp = new JEditorPane();
		editorPaneIp.setBounds(101, 112, 154, 20);
		add(editorPaneIp);
		
		JLabel lblNamn = DefaultComponentFactory.getInstance().createLabel("Name");
		lblNamn.setBounds(10, 66, 92, 14);
		add(lblNamn);
		
		JLabel lblIp = DefaultComponentFactory.getInstance().createLabel("IP(xx.xx.xx.xx)");
		lblIp.setBounds(10, 112, 92, 14);
		add(lblIp);
		
		JButton btnLogin = new JButton("Login");
		add(btnLogin);
		btnLogin.setBounds(10, 175, 89, 23);
		
		JButton btnSkapaNyttSpel = new JButton("Create new game");
		btnSkapaNyttSpel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				name = editorPaneName.getText();
				if(name != null && !name.equals(""))
				{
					createNewGame(name);
				}
			}
		});
		btnSkapaNyttSpel.setBounds(166, 175, 126, 23);
		add(btnSkapaNyttSpel);
		
		btnLogin.addMouseListener(new MouseAdapter() {
			
		@Override
		public void mouseClicked(MouseEvent arg0) {
			name = editorPaneName.getText();
			ip = editorPaneIp.getText();
			if(name != null && !name.equals("") && ip != null && !ip.equals(""))
			{
				continueProgram(name, ip);
			}
		}
		});	
	}
	
	private void continueProgram(String userName, String ip)
	{
		pHandler.connectToGame(userName, ip);
	}
	
	private void createNewGame(String userName)
	{
		try {
			pHandler.createNewGame(userName);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

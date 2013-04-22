package gui;
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
	private FrameHandler frameHandler;
	public String name;
	public String ip;
	private JEditorPane editorPaneName; 
	private JEditorPane editorPaneIp;
	private GameClient gameClient;
	/**
	 * Create the panel.
	 */
	public LoginPane(GameClient client, FrameHandler handler) {
		setLayout(null);
		this.frameHandler = handler;
		JLabel lblLogin = DefaultComponentFactory.getInstance().createLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogin.setBounds(10, 11, 120, 41);
		add(lblLogin);
		
		this.gameClient = client;
		
		this.editorPaneName = new JEditorPane();
		editorPaneName.setBounds(101, 63, 154, 20);
		add(editorPaneName);
		
		this.editorPaneIp = new JEditorPane();
		editorPaneIp.setBounds(101, 112, 154, 20);
		add(editorPaneIp);
		
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
		btnSkapaNyttSpel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameHandler.frame.setVisible(false);
				frameHandler.frame2.setVisible(true);
				name = editorPaneName.getText();
		
			}
		});
		btnSkapaNyttSpel.setBounds(166, 175, 126, 23);
		add(btnSkapaNyttSpel);
		
		btnLogin.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			name = editorPaneName.getText();
			ip = editorPaneIp.getText();
			if(true){
				
				
			}
			if(isConnected()){
			}
		}
		});

		
		
	}
	public boolean isConnected(){
		return true;
		
	}
}

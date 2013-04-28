package gui;
import game.ProgramHandler;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;


public class LoginFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	public LoginPane loginPane;

	/**
	 * Create the frame.
	 */
	public LoginFrame(FrameHandler handler, ProgramHandler pHandler){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		setSize(510, 600);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		loginPane = new LoginPane(pHandler);
		
		tabbedPane.addTab("LoginPane", null, loginPane,
				"LoginPane");
		tabbedPane.setSelectedIndex(0);
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}

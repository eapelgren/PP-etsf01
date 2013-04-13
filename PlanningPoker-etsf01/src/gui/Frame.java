package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;


public class Frame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private GamePane gamePane;
	private ResultPane resultPane;
	private LoginPane loginPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame(){
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
		
		loginPane = new LoginPane();
		
		gamePane = new GamePane();

		resultPane = new ResultPane();
		

		
		tabbedPane.addTab("LoginPane", null, loginPane,
				"LoginPane");
		
		
		
		tabbedPane.setSelectedIndex(0);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tabbedPane.removeTabAt(0);
		
		tabbedPane.addTab("GamePane", null, gamePane,
				
				"GamePane");
		tabbedPane.addTab("ResultPane", null, resultPane,
				"ResultPane");
		
	}

}

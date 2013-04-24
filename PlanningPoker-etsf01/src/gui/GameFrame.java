package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class GameFrame extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	public GamePane gamePane;
	public ResultPane resultPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public GameFrame() {
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
		gamePane = new GamePane();
		resultPane = new ResultPane();
		
		
		tabbedPane.addTab("GamePane", null, gamePane,
				"GamePane");
		tabbedPane.addTab("ResultPane", null, resultPane,
				"ResultPane");
	}
	
	public ResultPane getResultPane()
	{
		return resultPane;
	}
	
	public GamePane getGamePane()
	{
		return gamePane; 
	}

}

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

	//private String test;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	//public GamePane gamePane;
	//public ResultPane resultPane;
	public LoginPane loginPane;
	//public CreateQuestionPane cqp;



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
		
		loginPane = new LoginPane(handler, pHandler);
		
		//gamePane = new GamePane();

		//resultPane = new ResultPane();
		
		//cqp = new CreateQuestionPane();
		

		
		tabbedPane.addTab("LoginPane", null, loginPane,
				"LoginPane");
		//tabbedPane.addTab("GamePane", null, gamePane,
				
		//		"GamePane");
		//tabbedPane.addTab("ResultPane", null, resultPane,
		//		"ResultPane");
		
		//tabbedPane.addTab("CreateQuestionPane", null, cqp, "CreateQuestionPane");
		
		tabbedPane.setSelectedIndex(0);
	
	}
	
	public static void main (String [] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					LoginFrame frame = new LoginFrame(null, null);
					frame.setVisible(true);
					
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		});
	}

//	@Override
	//public void actionPerformed(ActionEvent e) {
	//	tabbedPane.removeTabAt(0);
		
	//	tabbedPane.addTab("GamePane", null, gamePane,
				
	//			"GamePane");
	//	tabbedPane.addTab("ResultPane", null, resultPane,
		//		"ResultPane");
		
	//}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

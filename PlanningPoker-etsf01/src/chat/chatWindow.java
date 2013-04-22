package chat;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;



import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class chatWindow extends JFrame {
	private TextField tf = new TextField();
	private TextArea ta = new TextArea();
	private String msgToSend; 
	
	public chatWindow(){
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout() );
		content.add("North",tf);
		content.add("Center",ta);
		tf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				msgToWrite(e.getActionCommand());
			}
		} );
		setContentPane(content);
		setTitle("Chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setVisible(true);
		pack();
	}
	
	private void msgToWrite(String msg)
	{
		msgToSend = msg; 
	}
	
	public String GetMessageToSendToServer()
	{
		String msg = msgToSend; 
		msgToSend = null;
		return msg; 
	}
	
	public void PutMessageInWindow(String message)
	{
		if(message!=null){
			ta.append(message+"\n");
			}
	}
}


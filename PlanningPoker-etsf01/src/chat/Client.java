package chat;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Client extends JFrame implements Runnable {
	
	private TextField tf = new TextField();
	private TextArea ta = new TextArea();
	private Socket socket;
	private DataOutputStream dout;
	private DataInputStream din;
	
	public Client(String host, int port){
		JPanel content = new JPanel();
		 content.setLayout(new BorderLayout() );
		 content.add("North",tf);
		 content.add("Center",ta);
		tf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			processMessage(e.getActionCommand());
			}
		} );
		setContentPane(content);
       setTitle("BorderTest");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       pack();	
		setVisible(true);
		
        
		try{
		socket = new Socket(host,port);
		System.out.println( "Uppkopplad till "+socket);
		din = new DataInputStream(socket.getInputStream());
		dout = new DataOutputStream(socket.getOutputStream());
		
		new Thread(this).start();
		
		}catch(IOException ie){
		System.out.println(ie);
		}
	}
	private void processMessage(String message){
		try{
			dout.writeUTF(message);
			tf.setText("");
		}
		catch(IOException ie){
			System.out.println("Kan ej skicka meddelande ");
		}
	}
	
		public void run(){
		try{
		while(true){
		String message = din.readUTF();
		ta.append(message+"\n");
		}
		}
		catch(IOException ie){
		System.out.println("Kan ej köra");
		}
	}
		public static void main(String args [] ){
			new Client("localhost", 30000);
			
		}
}
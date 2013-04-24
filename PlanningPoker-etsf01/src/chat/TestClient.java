package chat;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class TestClient {
	private String name;
	
	public  TestClient(){
		
		this.name = JOptionPane.showInputDialog( "Select your user name!");
		new ChatProgram(name);
	}	
	
	
	public static void main(String []args){
		new TestClient();
	}
}


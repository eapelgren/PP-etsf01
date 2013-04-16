package chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;

public class Server {
	private ServerSocket socket;
	private Hashtable outputStreams = new Hashtable();
	
	public Server(int port) throws IOException{
		listen(port);
	}
	
	
	public void listen(int port) throws IOException{
		socket = new ServerSocket(port);
		System.out.println("Lyssnar på "+socket);
		
		while(true){
				Socket newSocket = socket.accept();
				System.out.println("Uppkoppling från " + socket);
				DataOutputStream dout = new DataOutputStream(newSocket.getOutputStream());
				outputStreams.put(newSocket,dout);
				new ServerThread(this, newSocket);
		}
	}
	Enumeration getOutputStreams(){
	return outputStreams.elements();
	}

	public void sendToAll(String message) {
		synchronized(outputStreams){
				for(Enumeration e = getOutputStreams();e.hasMoreElements();){
					DataOutputStream dout = (DataOutputStream)e.nextElement();
					try{
					dout.writeUTF(message);
					}
					catch(IOException ie){
					System.out.println("Kan ej skicka");
					}
				}
			}
	}
				
	public void removeConnection(Socket s) {
		synchronized(outputStreams){
				
				System.out.println("Stänger ner uppkoppling till "+s);
				outputStreams.remove(s);
				try{
				s.close();
				}
				catch(IOException ie){
				System.out.println("Fel i nerkoppling "+s);
				ie.printStackTrace();
				}
	}
}
	
	 public static void main(String args[] )throws Exception {
		int port = 30000;
		new Server(port);
	}

}
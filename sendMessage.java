import java.io.*;
import java.net.Socket;

public class sendMessage extends Thread{
	BufferedReader source;
	DataOutputStream destination;
	Socket socket;
	public sendMessage(BufferedReader source, DataOutputStream destination, Socket socket) {
		this.source = source;
		this.destination = destination;
		this.socket = socket;
	}
	
	public void run() {
		String yourMessage;
		while (true) {
			// Get message from keyboard
			try {
				yourMessage = source.readLine();
				System.out.println("YOU : " + yourMessage);
				destination.writeBytes(yourMessage + '\n');
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 
	}
}

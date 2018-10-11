package Exercise3;

import java.net.*;
import java.io.*;

public class ConnectionThread extends Thread{
	Socket socket;
	
	public ConnectionThread(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}
	
	public void run() {
		try {
			// Get message from user console
			BufferedReader message_from_user = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						
			while (true) {
				String message = message_from_user.readLine();
				
				
				// Broadcast the message to all users
				for (int i = 0; i < Server.outputStreams.size(); i++) {
					Server.outputStreams.get(i).writeBytes(message + '\n');
				}
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}

package Exercise3;

import java.io.*;
import java.net.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hostname;
		
		try {
			hostname = InetAddress.getLocalHost().getHostName();
			Socket socket = new Socket(hostname, 4567);
			
			System.out.println("Successfully connected to server");
			
			// Input from user
			BufferedReader input_from_keyboard = new BufferedReader(new InputStreamReader(System.in));
			
			// Transmit message to the server
			DataOutputStream output_to_server = new DataOutputStream(socket.getOutputStream());
			
			// Server sends back messages from other users
			BufferedReader message_from_other_users = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
			// Create 2 threads to handle message and response
			messageThread message = new messageThread(input_from_keyboard, output_to_server);
			message.start();
			
			responseThread response = new responseThread(message_from_other_users);
			response.start();
			
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

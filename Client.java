import java.net.*;
import java.io.*;


public class Client {
	
	
	public static void main(String[] args) {
		
		String hostname;
		try {
			hostname = InetAddress.getLocalHost().getHostName();
				
			// Connect to the socket 
			Socket clientSocket = new Socket(hostname, 6789);
			
			// Create output to send to server
			DataOutputStream output_to_server = new DataOutputStream(clientSocket.getOutputStream());

			// Read response from server
			BufferedReader input_from_server = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			// Read input from keyboard
			BufferedReader input_from_client = new BufferedReader(new InputStreamReader(System.in));
			
			// Create 2 threads to handle input and output
			receiveMessage rMessage = new receiveMessage(input_from_server, "SERVER");
			sendMessage sMessage = new sendMessage(input_from_client, output_to_server,clientSocket);
			rMessage.start();
			sMessage.start();
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

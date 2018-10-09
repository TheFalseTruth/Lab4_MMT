import java.net.*;
import java.io.*;

public class Server {
	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(6789);
			
			// Accept incoming request
			Socket connectionSocket = serverSocket.accept();
			
			
			// Get input from client
			BufferedReader input_from_client = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			
			// Get input from keyboard
			BufferedReader input_from_server = new BufferedReader(new InputStreamReader(System.in));
			
			// Send output to client
			DataOutputStream output_to_client = new DataOutputStream(connectionSocket.getOutputStream());
			
			// Create 2 threads
			receiveMessage rMessage = new receiveMessage(input_from_client, "CLIENT");
			sendMessage sMessage = new sendMessage(input_from_server, output_to_client,connectionSocket);
			
			rMessage.start();
			sMessage.start();			
			

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

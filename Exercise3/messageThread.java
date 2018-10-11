package Exercise3;

import java.net.*;
import java.io.*;

public class messageThread extends Thread{
	BufferedReader reader;
	DataOutputStream outputStream;
	
	public messageThread(BufferedReader reader, DataOutputStream outputStream) {
		// TODO Auto-generated constructor stub
		this.reader = reader;
		this.outputStream = outputStream;
	}
	
	public void run() {
		try {
			while (true) {
				String message = reader.readLine();
				
				// Transfer the message to server
				outputStream.writeBytes(message + '\n');
				
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

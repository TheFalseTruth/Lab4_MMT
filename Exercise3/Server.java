package Exercise3;

import java.io.*;
import java.net.*;
import java.util.ArrayList;


public class Server {
	public static ArrayList<DataOutputStream> outputStreams = new ArrayList<DataOutputStream>();
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(4567);
			
			while (true) {
				Socket connectionSocket = serverSocket.accept();
				outputStreams.add(new DataOutputStream(connectionSocket.getOutputStream()));
				ConnectionThread connectionThread = new ConnectionThread(connectionSocket);
				connectionThread.start();
				System.out.println("Another Client has arrived");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

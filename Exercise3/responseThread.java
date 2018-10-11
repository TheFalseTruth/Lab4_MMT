package Exercise3;

import java.net.*;
import java.io.*;

public class responseThread extends Thread{
	BufferedReader reader;
	
	public responseThread(BufferedReader reader) {
		// TODO Auto-generated constructor stub
		this.reader = reader;
	}
	
	public void run() {
		try {
			while (true) {
				String response = reader.readLine();
				System.out.println("MESSAGE : " + response);
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}

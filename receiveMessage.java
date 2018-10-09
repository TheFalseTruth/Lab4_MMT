import java.io.BufferedReader;
import java.io.IOException;

public class receiveMessage extends Thread{
	String name;
	BufferedReader response;
	
	public receiveMessage(BufferedReader response, String name) {
		this.name = name;
		this.response = response;
	}
	
	public void run() {
		try {
			while (true) {
				String response = this.response.readLine();
				System.out.println(this.name + " : " + response);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		
	
}

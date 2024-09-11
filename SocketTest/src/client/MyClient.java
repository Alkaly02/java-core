package client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MyClient {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 8550);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF("Hello guys");
			s.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}

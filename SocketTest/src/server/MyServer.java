package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8550);
			Socket s = ss.accept();
			
			DataInputStream is = new DataInputStream(s.getInputStream());
			DataOutputStream os = new DataOutputStream(s.getOutputStream());
			
			String str = is.readUTF();
			
			System.out.println("Message: " + str);
			
			ss.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

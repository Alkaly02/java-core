package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(1234);
			
			System.out.println("J'attends la connexion");
			
			Socket s = ss.accept();
			
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			
			int nb = is.read();
			System.out.println("J'ai recu: "+ nb);
			
			os.write(nb * 100);
			
			s.close();
			ss.close();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}

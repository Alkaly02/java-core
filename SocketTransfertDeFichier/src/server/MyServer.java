package server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(6543);
		Socket socket = ss.accept();
		
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		
		is.read();
				
	}
}

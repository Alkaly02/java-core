package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MyClient {
	public static void main(String[] args) throws IOException {
		Socket ss = new Socket("localhost", 1234);
		
		InputStream is = ss.getInputStream();
		OutputStream os = ss.getOutputStream();
		
		os.write(2);
		System.out.println("2 envoye au serveur");
		
		int res = is.read();
		
		System.out.println("Resultat: " + res);
		ss.close();
	}

}

package client;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class MyClient {
	private static DataOutputStream dataOutputStream;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Socket socket = new Socket("localhost", 6666);
		dataOutputStream = new DataOutputStream(socket.getOutputStream());
//		Envoie de fichier
		sendFile("tonux.png");
		dataOutputStream.close();
		socket.close();
	}

	private static void sendFile(String filePath) throws Exception {
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		
//		envoyer la taille du fichier au serveur
//		dataOutputStream.writeChars(file.getEx);
		dataOutputStream.writeLong(file.length());
		
		int bytes;
		byte[] buffer = new byte[8*1024];
//		envoie du fichier par morceaux de 1Ko
		int i = 0;
		long startTime = System.currentTimeMillis();
		while((bytes = fis.read(buffer)) != -1) {
			dataOutputStream.write(buffer, 0, bytes);
			dataOutputStream.flush();
//			System.out.print(i);
			i++;
		}
		long stopTime = System.currentTimeMillis();
		fis.close();
		System.out.println(stopTime - startTime);
	}
}

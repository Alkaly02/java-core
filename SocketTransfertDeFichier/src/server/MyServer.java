package server;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	private static DataInputStream dataInputStream;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(7777);
		Socket socketClient = ss.accept();
		
		dataInputStream = new DataInputStream(socketClient.getInputStream());
		receiveFile("receivedFile.txt");
		socketClient.close();
		ss.close();
				
	}
	
	private static void receiveFile(String newFile) throws Exception {
		File file = new File(newFile);
		FileOutputStream fos = new FileOutputStream(file);
		
		int bytes;
		byte[] buffer = new byte[4*1024];
		
//		recuperer la taille du fichier
		long receivedFileSizes = dataInputStream.readLong();
		
		while(receivedFileSizes > 0 && (bytes = dataInputStream.read(buffer, 0, (int)Math.min(buffer.length, receivedFileSizes))) != 1) {
			fos.write(buffer, 0, bytes);
			receivedFileSizes-=bytes;
		}
		
		fos.close();
		
	}
}

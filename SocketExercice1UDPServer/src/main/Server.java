package main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {

	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(8765);
		byte[] receivedData = new byte[1024];
		
		while(true) {
			DatagramPacket packet = new DatagramPacket(receivedData, receivedData.length);
			socket.receive(packet);
			String message = new String(packet.getData(), 0, packet.getLength());
			System.out.println("Message recu: " + message);
			
			InetAddress adress = packet.getAddress();
			int port = packet.getPort();
//			envoie de message de reception
			byte[] messageReceived = "Bien recu".getBytes();
			DatagramPacket receptionPacket = new DatagramPacket(messageReceived, messageReceived.length, adress, port);
			socket.send(receptionPacket);
		}
	}

}

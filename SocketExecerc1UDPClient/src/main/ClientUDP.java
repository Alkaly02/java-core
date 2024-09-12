package main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientUDP {

	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket();
		InetAddress adress = InetAddress.getByName("localhost");
		
		byte[] message1 = "Salut, cv?".getBytes();
		byte[] message2 = "J'espere que tu vas bien! Akay".getBytes();
		
		DatagramPacket packet1 = new DatagramPacket(message1, message1.length, adress, 8765);
		socket.send(packet1);
		packet1 = new DatagramPacket(message1, message1.length);
		socket.receive(packet1);
		String receive1 = new String(packet1.getData(), 0, packet1.getLength());
		System.out.println("receive1: " + receive1);
		
		DatagramPacket packet2 = new DatagramPacket(message2, message2.length, adress, 8765);
		socket.send(packet2);
		packet2 = new DatagramPacket(message2, message2.length);
		socket.receive(packet2);
		String receive2 = new String(packet2.getData(), 0, packet2.getLength());
		System.out.println("receive2: " + receive2);
		
		socket.close();
	}

}

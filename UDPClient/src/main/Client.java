package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		final int PORT = 8765;
		
		DatagramSocket socket = new DatagramSocket();
		InetAddress address = InetAddress.getByName("localhost");
		
		byte[] message1 = "Je suis le message 1".getBytes();
		byte[] message2 = "Je suis le message 2".getBytes();
		
		sendPacket(message1, address, PORT, socket);
		String accuseReception1 = getMessage(message1, socket);
		System.out.println("Accuse reception 1: "+accuseReception1);
		
		
		sendPacket(message2, address, PORT, socket);
		String accuseReception2 = getMessage(message2, socket);
		System.out.println("Accuse reception 2: "+accuseReception2);
		
		socket.close();
	}
	
	public static void sendPacket(byte[] message, InetAddress address, int PORT, DatagramSocket socket) throws IOException {
		DatagramPacket packet1 = new DatagramPacket(message, message.length, address, PORT);
		socket.send(packet1);
	}
	
	public static String getMessage(byte[] message, DatagramSocket socket) throws IOException {
		DatagramPacket packetReception1 = new DatagramPacket(message, message.length);
		socket.receive(packetReception1);
		String accuseReception = new String(packetReception1.getData(), 0, packetReception1.getLength());
		return accuseReception;
	}

}

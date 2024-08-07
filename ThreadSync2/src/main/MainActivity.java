package main;

import models.*;

public class MainActivity {

	public static void main(String[] args) {
		Counter counter = new Counter();
		
		CounterThread obj1 = new CounterThread(counter);
		CounterThread obj2 = new CounterThread(counter);
		
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		}catch(InterruptedException ie) {
			ie.printStackTrace();
			System.out.println(ie.getMessage());
		}
		
		System.out.println("Counter thread : "+ counter.getCount());
	}

}

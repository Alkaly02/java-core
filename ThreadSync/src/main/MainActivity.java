package main;

import models.*;

public class MainActivity {

	public static void main(String[] args) {
		Counter count1 = new Counter();
		
		CounterThread obj1 = new CounterThread(count1);
		CounterThread obj2 = new CounterThread(count1);
		
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		
		System.out.println("Counter thread : "+ count1.getCount());
		
	}

}

package main;

import threads.AppThread;

public class MainActivity {
	public static void main(String[] args) {
		AppThread t1 = new AppThread("Thread 1");
		AppThread t2 = new AppThread("Thread 2");
		AppThread t3 = new AppThread("Thread 3");

		t1.start();
		t2.start();
		t3.start();
	}
}

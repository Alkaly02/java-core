package models;

public class CounterThread implements Runnable {
	private Counter counter;
	
	public CounterThread(Counter counter) {
		this.counter = counter;
	}
	
	public void run() {
		for(int i=0; i<=5; i++) {
			counter.increment();
		}
	}
}

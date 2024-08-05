package models;

public class Counter {
	private int count;
	
	public synchronized void increment() {
		this.count += 1;
	}
	
	public int getCount() {
		return this.count;
	}
}

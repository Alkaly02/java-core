package main;

class Q{
	private int num;
	
	public void put(int num) {
		this.num = num;
	}
	
	public int get() {
		return this.num;
	}
}

class Producer implements Runnable{
	Q q;
	public Producer(Q q) {
		this.q = q;
	}
	
	public void run() {
		int i = 0;
		while(true) {
			q.put(i);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException ie) {
				
			}
		}
	}
}

class Consumer implements Runnable{
	Q q;
	public Consumer(Q q) {
		this.q = q;
	}
	
	public void run() {
		
	}
}

public class InterThread {

	public static void main(String[] args) {
		
	}

}

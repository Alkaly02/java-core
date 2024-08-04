package main;

public class MainActivity {

	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println("Current thread: " + t);
		t.setName("MainThread");
		System.out.println("The current thread after name change: " + t);
		System.out.println("The current thread is going to sleep for 10 seconds");
		try {
			Thread.sleep(10000);
		}catch(InterruptedException ie) {
			System.out.println("Main thread interrupted");
		}
		System.out.println("After 10 seconds..................the current Thread is existing now");
	}

}

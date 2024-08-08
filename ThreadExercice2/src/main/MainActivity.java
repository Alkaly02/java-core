package main;

class SharedResource {
	private String name;
	private boolean isNameEditing=false;
	public synchronized void produce(String name) throws InterruptedException {
		if(this.isNameEditing) {
			wait();
		}
		this.isNameEditing=true;
		this.name = name;
		notifyAll();
	}
	
	public synchronized String consume() throws InterruptedException {
		if(!this.isNameEditing) {
			wait();
		}
		this.isNameEditing=false;
		notifyAll();
		return this.name;
	}
}

class Producer implements Runnable{
	private SharedResource shared;
	public Producer(SharedResource shared) {
		this.shared=shared;
	}
	public void run() {
		try {
			shared.produce("Alkaly");
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}

class Consumer implements Runnable{
	private SharedResource shared;
	public Consumer(SharedResource shared) {
		this.shared=shared;
	}
	public void run() {
		try {
			shared.consume();
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}

public class MainActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SharedResource resource = new SharedResource();
		Producer obj1 = new Producer(resource);
		Consumer obj2 = new Consumer(resource);
		
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

	}

}

package threads;

public class AppThread extends Thread {
	private Thread t;
	
	public AppThread(String threadName) {
		t = new Thread();
		t.setName(threadName);
	}
	
	@Override
	public void run() {
		System.out.println("Bonjour et bienvenu sur " + t.getName());
	}
}

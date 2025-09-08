package busywait;

public class Main {
	
	public static String melding;
	
	public static void main(String[] args) {
		
		Object lock = new Object();
		
		//En tråd som skriver ut melding på skjermen
		Thread t1 = new Thread (new Runnable() {
			@Override
			public void run() {
				synchronized(lock) {
				while (melding == null) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
				}
			}
				System.out.println(melding);
				
				}
			}	
		});
		
		//En tråd som gir melding en verdi
		Thread t2 = new Thread (new Runnable() {
			@Override
			public void run() {
				synchronized(lock) {
				melding = "Hallo";
				lock.notifyAll();
				}
			}
			
		});
		t1.start();
		t2.start();
	}
}

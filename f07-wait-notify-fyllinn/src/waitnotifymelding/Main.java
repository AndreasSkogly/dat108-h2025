package waitnotifymelding;

public class Main {
	
	public static Melding melding = new Melding();
	
	public static void main(String[] args) {
		
	//	Object lock = new Object();
		
		//En tråd som skriver ut melding på skjermen
		Thread t1 = new Thread (() -> System.out.println(melding.getTekst()));
				
		//newRunnable() {
		//@Override
		//public void run() {
		//System.out.println(melding.getTekst());
				
				
	
	
		
		//En tråd som gir melding en verdi
		Thread t2 = new Thread (() -> melding.setTekst("Hallo!"));
		
		//	@Override
		//	public void run() {
		//	synchronized(melding) {
		//			melding.setTekst("Hallo!");
		//	melding.notifyAll();
		//		}
		//	}
	
	
		t1.start();
		t2.start();
	
	}
}

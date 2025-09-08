package dat108.eksv21.oppg5;

public class UtskriftsloopTraad extends Thread {	
	
	private boolean fortsett = true;
	
	public void stopp() {
		fortsett = false;
		
		
		}
	
	@Override
	public void run() {
		
		while (fortsett) {
			System.out.println("Hallo");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			
			}
		}
	}


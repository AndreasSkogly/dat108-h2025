package lockawaitsignal;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main1SyncWaitNotify {
	

	public static void main(String[] args) {

		Melding melding = new Melding();
		Lock lock = new ReentrantLock();
		Condition tekstErSatt = lock.newCondition();

		Thread printlnTraad = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.lock();
				while (melding.harTekst()) {
				try {
					tekstErSatt.await();
					melding.wait();
				} catch (InterruptedException e) {
					}
					}
					System.out.println(melding.getTekst());
					lock.unlock();
				}
		});

		Thread giVerdiTraad = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized(melding) {
				melding.setTekst("Hallo");
				melding.notifyAll();
				}
			}
		});

		printlnTraad.start();
		giVerdiTraad.start();
	}

}

package allchapters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EdSynchronized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynchronizedUtils sU = new SynchronizedUtils();
		sU.runSheepCounter();
	}
}

class SynchronizedUtils {
	void runSheepCounter() {
		ExecutorService svc = null;
		try {
			svc = Executors.newFixedThreadPool(5);
			SheepCounter sC = new SheepCounter();	
			for (int i = 0;i<10;i++) {
				svc.submit(()->sC.runSheepCounterSync());
			}
		} finally {
			if(svc!=null) svc.shutdown();
		}
	}
}

class SheepCounter {
	private int sheepCount = 0;
	void runSheepCounter() {
		//System.out.print(++sheepCount + " ");
		//
		synchronized(this) {
			System.out.print(++sheepCount + " ");
		}
		//
	}
	synchronized void runSheepCounterSync() {
		System.out.print(++sheepCount + " ");
	}
}

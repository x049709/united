package allchapters;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EdCyclicBarrierFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CBUtilsFour cB = new CBUtilsFour();
		cB.runCyclicBarrier();
	}

}

class CBUtilsFour {
	void runCyclicBarrier() {
		ExecutorService svc = null;
		try {
			svc = Executors.newFixedThreadPool(15); //must be at least = cyclicbarrier
			PenManagerFour pM = new PenManagerFour();
			for (int i=0;i<10;i++) {//must be EQUAL to CyclicBarrier count, otherwise unpredictable results
				svc.submit(()->pM.doDenTasks());
			}
		} finally {
			if (svc!=null) svc.shutdown();
		}
	}
	
}

class PenManagerFour {
	CyclicBarrier cA = new CyclicBarrier(10,()->System.out.println("Barrier A opened"));
	CyclicBarrier cB = new CyclicBarrier(10,()->System.out.println("Barrier B opened"));
	private void removeLions() {
		System.out.println("Removed lions by " + Thread.currentThread().getName());
	}
	private void cleanPen() {
		System.out.println("Pen cleaned by " + Thread.currentThread().getName());
	}
	private void addBackLions() {
		System.out.println("Lions are back in the pen by " + Thread.currentThread().getName());
	}
	public void doDenTasks () {
		try {
			removeLions();
			cA.await();
			cleanPen();
			cB.await();
			addBackLions();
		} catch (InterruptedException | BrokenBarrierException e) {
			System.out.println("Ooops...");
		}
	}
}
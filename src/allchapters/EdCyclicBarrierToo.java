package allchapters;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class EdCyclicBarrierToo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CBUtilsToo cB = new CBUtilsToo();
		cB.runCyclicBarrier();
	}

}

class CBUtilsToo {
	void runCyclicBarrier() {
		ExecutorService svc = null;
		try {
			svc = Executors.newFixedThreadPool(15); //must be at least = cyclicbarrier
			PenManager pM = new PenManager();
			CyclicBarrier c1 = new CyclicBarrier(10,()->System.out.println("Barrier 1 opened"));
			CyclicBarrier c2 = new CyclicBarrier(10,()->System.out.println("Barrier 2 opened"));
			for (int i=0;i<10;i++) {//must be EQUAL to CyclicBarrier count, otherwise unpredictable results
				svc.submit(()->pM.doDenTasks(c1, c2));
			}
		} finally {
			if (svc!=null) svc.shutdown();
		}
	}
	
}

class PenManager {
	private void removeLions() {
		System.out.println("Removed lions by " + Thread.currentThread().getName());
	}
	private void cleanPen() {
		System.out.println("Pen cleaned by " + Thread.currentThread().getName());
	}
	private void addBackLions() {
		System.out.println("Lions are back in the pen by " + Thread.currentThread().getName());
	}
	public void doDenTasks (CyclicBarrier c1, CyclicBarrier c2) {
		try {
			removeLions();
			c1.await();
			cleanPen();
			c2.await();
			addBackLions();
		} catch (InterruptedException | BrokenBarrierException e) {
			System.out.println("Ooops...");
		}
	}
}
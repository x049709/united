package allchapters;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class EdCyclicBarrierThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CBUtils cB = new CBUtils();
		cB.runCBAwait();

	}

}

class CBUtils {
	void runCBAwait () {
		AwaitCB awcb = new AwaitCB();
		CyclicBarrier cb = new CyclicBarrier (9, ()-> System.out.println("Stock room full!"));
		IntStream.iterate(1, i -> 1).limit(9).parallel().forEach(i->awcb.awaitIt(cb));
	}
		
}

class AwaitCB {
	void awaitIt (CyclicBarrier cb) {
		try {
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			
		}
	}
}

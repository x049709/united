package allchapters;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class EdSingleExecutor {

	public static void main(String[] args) throws TimeoutException, InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorUtils eU = new ExecutorUtils();
		eU.singleScheduledExecutor();
		eU.singleExecutor();
		eU.singleExecutorWithFuture();
		eU.singleExecutorWithFutureAndCallable();

	}

}

class ExecutorUtils {
	
	void singleScheduledExecutor () throws TimeoutException, InterruptedException, ExecutionException {
		ScheduledExecutorService svc = null;
		System.out.println("singleScheduledExecutor:");
		svc = Executors.newSingleThreadScheduledExecutor();
		Callable<String> callableTask = ()->"Hello from callable";
		Runnable runnableTask = ()->System.out.println("Hello from runnable");
		Future<?> skedCallable = svc.schedule(callableTask,4000,TimeUnit.MILLISECONDS);
		Future<?> skedRunnable = svc.schedule(runnableTask,2000, TimeUnit.MILLISECONDS);
		System.out.println(skedCallable.get());
	}

	void singleExecutorWithFutureAndCallable () throws TimeoutException, InterruptedException, ExecutionException {
		ExecutorService svc = null;
		System.out.println("singleExecutorWithFutureAndCallable:");
		try {
			svc = Executors.newSingleThreadExecutor();
			svc.submit(()-> System.out.println("Begin!!!"));
			svc.submit(()-> System.out.println("Print loop:"));
			Future <?> result = svc.submit(()-> 2+3);
			System.out.println(result.get());
			svc.submit(()-> System.out.println("End!!!"));
		} catch (InterruptedException e) {
		} catch (ExecutionException e) {
		} finally {
			if (svc != null) {
				svc.submit(()-> System.out.println("Finally!!!"));
				svc.shutdown();
				System.out.println("shutdown? " + svc.isShutdown());
				System.out.println("terminated? " + svc.isTerminated());
			}
		}
	}


	void singleExecutor () {
		ExecutorService svc = null;
		try {
			svc = Executors.newSingleThreadExecutor();
			svc.execute(()-> System.out.println("Begin!!!"));
			svc.execute(()-> System.out.println("Print loop:"));
			svc.execute(()-> printLoop());	
			svc.execute(()-> System.out.println("End!!!"));
			System.out.println("shutdown? " + svc.isShutdown());
			System.out.println("terminated? " + svc.isTerminated());
		} finally {
			if (svc != null) {
				svc.execute(()-> System.out.println("Finally!!!"));
				svc.shutdown();
				System.out.println("shutdown? " + svc.isShutdown());
				System.out.println("terminated? " + svc.isTerminated());
			}
		}
	}

	void singleExecutorWithFuture () throws TimeoutException, InterruptedException, ExecutionException {
		ExecutorService svc = null;
		try {
			svc = Executors.newSingleThreadExecutor();
			svc.submit(()-> System.out.println("Begin!!!"));
			svc.submit(()-> System.out.println("Print loop:"));
			Future <?> result = svc.submit(()-> printLoop());
			result.get(1, TimeUnit.NANOSECONDS);
			svc.submit(()-> System.out.println("End!!!"));
			System.out.println("shutdown? " + svc.isShutdown());
			System.out.println("terminated? " + svc.isTerminated());
		} catch (TimeoutException e) {
		} catch (InterruptedException e) {
		} catch (ExecutionException e) {
		} finally {
			if (svc != null) {
				svc.submit(()-> System.out.println("Finally!!!"));
				svc.shutdown();
				System.out.println("shutdown? " + svc.isShutdown());
				System.out.println("terminated? " + svc.isTerminated());
			}
		}
	}

	void printLoop() {
		for (int i=0;i<3;i++) {
			System.out.println("Loop:" + i);
		}	
		return;//same as no return at all
	}
	
}
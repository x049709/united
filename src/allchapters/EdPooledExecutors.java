package allchapters;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class EdPooledExecutors {

	public static void main(String[] args) throws TimeoutException, InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		PooledExecutorUtils eU = new PooledExecutorUtils();
		eU.pooledScheduledExecutor();

	}

}

class PooledExecutorUtils {
	
	void pooledScheduledExecutor () throws TimeoutException, InterruptedException, ExecutionException {
		ScheduledExecutorService svc = null;
		System.out.println("singleScheduledExecutor:");
		svc = Executors.newScheduledThreadPool(5);
		Callable<String> callableTask = ()->"Hello from callable";
		Runnable runnableTask = ()->System.out.println("Hello from runnable");
		svc.scheduleAtFixedRate(runnableTask, 1000, 1000, TimeUnit.MILLISECONDS);
	}

	
}
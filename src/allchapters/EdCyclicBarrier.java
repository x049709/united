package allchapters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class EdCyclicBarrier {

	public static void main(String[] args) {
		new CBMain();
	}
}

class CBMain {
	List<String> result = new ArrayList<>();
	static String[] dogs1 = {"boi","clover","charis"};
	static String[] dogs2 = {"aiko","zooey","biscuit"};
	
	CyclicBarrier barrier = null;
	
	public CBMain () {		
		barrier = new CyclicBarrier(2, () -> { //This syntax means the return type is void
			for (int i = 0; i< dogs1.length;i++) {
				result.add(dogs1[i]);
			}
			for (int i = 0; i< dogs2.length;i++) {
				result.add(dogs2[i]);
			}
			System.out.println(Thread.currentThread().getName() + " Result: " + result);
		});
	
		/* NOT USING LAMBDA
		BarrierRunnable br = new BarrierRunnable();
		barrier = new CyclicBarrier(2,br);
		*/
		
		Thread t1 = new Thread(new ProcessDogs(dogs1));
		Thread t2 = new Thread(new ProcessDogs(dogs2));
		
		t1.start();
		t2.start();
	}
	
	class ProcessDogs implements Runnable {
		String [] dogs;
		ProcessDogs (String[] d) {
			this.dogs = d;
		}
		public void run () {
			for (int i=0;i< dogs.length; i++) {
				String dogName = dogs[i];
				String newDogName = dogName.substring(0,1).toUpperCase() + dogName.substring(1);
				dogs[i] = newDogName;
			}
			
			try {
					barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() + " is done: " + Arrays.toString(dogs));
			System.out.println(Thread.currentThread().getName() + " is done with lambda: ");
			Arrays.stream(dogs).forEach(d-> System.out.println(d));
			System.out.println(Thread.currentThread().getName() + " is done with method reference: ");
			Arrays.stream(dogs).forEach(System.out::println);
		}
	}
	
	//This class only exists if we are not using lambda
	class BarrierRunnable implements Runnable {
		public void run () {
			for (int i = 0; i< dogs1.length;i++) {
				result.add(dogs1[i]);
			}
			for (int i = 0; i< dogs2.length;i++) {
				result.add(dogs2[i]);
			}
			System.out.println(Thread.currentThread().getName() + " Result: " + result);
			
		}
	}

}


class CBMainUser {
	String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}


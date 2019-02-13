package allchapters;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class EdForkJoinPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FJPUtils fjp = new FJPUtils();
		System.out.println(fjp.factorial(5));
		fjp.fjpWeighAnimals();

	}

}
class FJPUtils {
	int factorial(int n) {
		if(n<=1) return 1;
		else return n*factorial(n-1);
	}
	
	void fjpWeighAnimals() {
		Integer[] weights = new Integer[10];
		ForkJoinTask<?> task = new WeighAnimalAction(weights,0,weights.length);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);
		
		System.out.println("Weights:");
		Arrays.asList(weights).stream().forEach(d->System.out.print(d.toString() + " "));
	}
}

class WeighAnimalAction extends RecursiveAction {
	private int start, end;
	private Integer[] weights;
	public WeighAnimalAction (Integer[] weights, int start, int end) {
		this.start = start;
		this.end = end;
		this.weights = weights;
	}
	
	protected void compute() {
		if(end - start <= 3) {
			//System.out.println("Calcing:");
			for (int i=start;i < end;i++) {
				weights[i] = new Random().nextInt(100);
				System.out.println(" Animal " + i + " weighed: " + weights[i]);
			}
		} else {
			int mid = start + ((end-start)/2);
			System.out.println("[start=" + start + ",mid=" + mid + ",end=" + end +"]");
			invokeAll(new WeighAnimalAction(weights,start,mid),new WeighAnimalAction(weights,mid,end));
		}
	}
}
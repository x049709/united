package allchapters;

import java.util.Arrays;
import java.util.stream.Stream;

public class EdParallelStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParallelUtils pU = new ParallelUtils();
		pU.parArrayStream();
		pU.parArrayStreamOrdered();

	}

}

class ParallelUtils {
	void parArrayStream () {
		System.out.println("\nNot ordered:");
		Stream<Integer> iA = Arrays.asList(1,2,3,4,5,6).parallelStream();
		iA.forEach(System.out::print);
	}
	void parArrayStreamOrdered () {
		System.out.println("\nOrdered:");
		Stream<Integer> iA = Arrays.asList(1,2,3,4,5,6).parallelStream();
		//iA.forEach(System.out::print);
		iA.forEachOrdered(x->System.out.print(x + ","));
	}
}

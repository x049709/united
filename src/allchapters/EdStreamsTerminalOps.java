package allchapters;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EdStreamsTerminalOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TerminalOperations tO = new TerminalOperations();
		tO.reduceIt();
		tO.countIt();
		tO.minIt();
		tO.findIt();
		tO.collectIt();
		tO.collectItUnsorted();

	}

}

class TerminalOperations {
	
	void reduceIt() {
		Stream<Integer> s = Stream.of();
		Optional<Integer> x = s.reduce((left, right) -> Math.max(left, right));
		System.out.println("Reduced to:" + x);		

		Stream<Integer> p = Stream.of(3, 6,12, 0, -12, 100000);
		Optional<Integer> q = p.reduce(Math::max);
		System.out.println("Reduced to:" + q);		

		Stream<Integer> r = Stream.of(3, 6,12, 0, -120, 100000);
		Integer v = r.reduce(-25,(left, right) -> Math.min(left, right));
		System.out.println("Reduced to:" + v);		

		Stream<Double> h = Stream.of(3.0, 6.0,12.0, 0.0, -120.0, -0010000000000.0);
		Double i = h.reduce(2000000025.2,(left, right) -> left + right);
		System.out.println("Reduced to:" + i);		

		Stream<String> g = Stream.of("p","o","g","i");
		Optional<String> k = g.reduce((left, right) -> left+right);
		System.out.println("Reduced to:" + k);		



	}
	void countIt () {
		Stream<String> s = Stream.of("monkey", "gorilla","bonobo");
		System.out.println("Count:" + s.count());		
	}
	
	void minIt () {
		Stream<String> t = Stream.of("monkey", "gorilla","bonobo");
		Comparator<String> cI = ( s1,  s2) -> s1.length() - s2.length();
		System.out.println("Min:" + t.min(cI));		
		
	}
	void findIt () {
		Stream<String> t = Stream.of("yoyomonkey", "gorilla","bonobo");
		Optional<String> anyS = t.findAny();
		anyS.ifPresent(System.out::println);		
		
	}
	
	void collectIt () {
		Stream<String> t = Stream.of("yoyomonkey", "gorilla","bonobo");
		Set<String> v = t.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(v);
	}
	void collectItUnsorted () {
		Stream<String> t = Stream.of("yoyomonkey", "gorilla","bonobo");
		Set<String> v = t.collect(Collectors.toSet());
		System.out.println(v);
	}
}

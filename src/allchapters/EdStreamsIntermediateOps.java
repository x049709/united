package allchapters;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class EdStreamsIntermediateOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntermediateOperations iO = new IntermediateOperations();
		iO.distinctIt();
		iO.mapIt();
		iO.mapItAgain();
		iO.flatmapIt();
		iO.flatmapReverseSortedIt();
		iO.testMethodRef();
		iO.peekIt();
	}

}

class IntermediateOperations {
	void distinctIt () {
		Stream<String> s = Stream.of("monkey", "gorilla","bonobo", "monkey", "bonobo", "monkeys");
		s.distinct().forEach(System.out::println);
		//s.distinct().forEachOrdered(System.out::println);
	}
	
	void mapIt () {
		Stream<String> s = Stream.of("monkey", "gola","bonjjjjobo", "my", "bbo", "mongyy999uiuiuiiuiugkeys");
		Stream<Integer> i = s.map(x -> x.length()*1000);
		i.forEach(System.out::println);
	}
	void mapItAgain () {
		Stream<String> s = Stream.of("monkey", "gola","bonjjjjobo", "mo9909nkey", "bommmmmnobo", "mongyygkeys");
		Stream<Integer> i = s.map(x -> x.length()*17);
		i.forEach(System.out::println);
		Stream<String> s2 = Stream.of("moffefnkey", "gola","bonerrrejjjjobo", "mottttrr9909nkey", "boghyymmmmmnobo", "mongyygkeys");
		Stream<Integer> i2 = s2.map(String::length);
		i2.forEach(System.out::println);
	}
	void flatmapIt () {
		List<String> one = Arrays.asList("help");
		List<String> three = Arrays.asList("mhe","she","they");
		List<String> four = Arrays.asList("hey", "mama","dada","dude");
		Stream<List<String>> s = Stream.of(one, three, four);
		Stream<String> f = s.flatMap(l->l.stream());
		f.sorted().forEach(System.out::println);
	}
	
	void flatmapReverseSortedIt () {
		List<String> one = Arrays.asList("help");
		List<String> three = Arrays.asList("mhe","she","they");
		List<String> four = Arrays.asList("hey", "mama","dada","dude");
		Stream<List<String>> s = Stream.of(one, three, four);
		Stream<String> f = s.flatMap(l->l.stream());
		f.sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
	}
	
	void peekIt () {
		List<String> one = Arrays.asList("help");
		List<String> three = Arrays.asList("mhe","she","they");
		List<String> four = Arrays.asList("hey", "mama","dada","dude");
		Stream<List<String>> s = Stream.of(one, three, four);
		Stream<String> f = s.flatMap(l->l.stream());
		Stream<String> w = f.filter(q->q.startsWith("h"));		
		w.peek(h->System.out.println("from peek:")).forEach(System.out::println);
		
	}
	
	void testMethodRef () {
		List<String> three = Arrays.asList("EEEEEEmhe","SSSSSshe","TTTTTthey");
		Set<String> sS = new TreeSet<>(Comparator.reverseOrder());
		sS.addAll(three);
		//for (String sx: three) {
		//	sS.add(sx);
		//}
		sS.forEach(System.out::println);
		
		//This does not compile 
		//Comparator<String> sW = Comparator::reverseOrder
		
	}
}


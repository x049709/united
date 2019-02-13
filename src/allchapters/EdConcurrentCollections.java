package allchapters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class EdConcurrentCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcUtils cU = new ConcUtils();
		cU.concHashMap();
		cU.notConcHashMap();
		cU.copyOnWrite();
		cU.notCopyOnWrite();
	}

}

class ConcUtils {
	void concHashMap () {
		Map <String, Integer> mP = new ConcurrentHashMap<>();
		mP.put("A", 1);
		mP.put("N", 3);
		mP.put("X", 15);
		
		System.out.println("\nbefore:");
		for (String k: mP.keySet()) {
			System.out.println(k);
			mP.remove(k);
		}
	}
	void notConcHashMap () {
		Map <String, Integer> mP = new HashMap<>();
		mP.put("A", 1);
		mP.put("N", 3);
		mP.put("X", 15);
		
		System.out.println("\nafter:");
		for (String k: mP.keySet()) {
			System.out.println(k);
			mP.remove(k);
		}
	}
	
	void copyOnWrite () {
		List<Integer> a = new CopyOnWriteArrayList<>(Arrays.asList(1,4,5));
		System.out.println("\nbefore:");
		for (int aI:a) {
			System.out.print(aI + " ");
			a.add(3);
		}
		System.out.println("\nafter:");
		a.add(7);
		for (Integer aI:a) {
			System.out.print(aI + " ");
		}
	}
	void notCopyOnWrite () {
		List<Integer> a = new ArrayList<>(Arrays.asList(1,4,5));
		System.out.println("\nbefore:");
		for (Integer aI:a) {
			System.out.print(aI + " ");
			a.add(3);
		}
		System.out.println("\nafter:");
		a.add(7);
		for (Integer aI:a) {
			System.out.print(aI + " ");
		}
	}
}
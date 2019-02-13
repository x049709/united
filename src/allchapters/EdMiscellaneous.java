package allchapters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EdMiscellaneous {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiscUtils x = new MiscUtils();
		x.printProperties();
	}

}

class MiscUtils {
	void arrList() {
		List<Integer> l1 = Arrays.asList(1,4,5,7);
		List<Integer> l2 = new CopyOnWriteArrayList(l1);
		l2.add(5);
		l2.add(8);
		System.out.println(l1.toString());
		System.out.println(l2.toString());
	}
	
	void printProperties() {
		int maxLen = System.getProperties().keySet()
			    .stream().mapToInt(k -> ((String)k).length()).max().orElse(0);
		String format = "%-"+maxLen+"s %s%n";
		System.getProperties().forEach((k,v)->System.out.printf(format, k+":", v));
	}
}

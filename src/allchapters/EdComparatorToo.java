package allchapters;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EdComparatorToo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sorted s1 = new Sorted(5, "a");
		Sorted s2 = new Sorted(3, "b");
		TreeSet<Sorted> t1 = new TreeSet<>(s2);
	}

}

class Sorted implements Comparable<Sorted>, Comparator<Sorted> {
	private int num;
	private String text;
	
	Sorted (int n, String t) {
		this.num =n;
		this.text=t;
	}
	public String toString() {
		return "";
	}
	public int compareTo(Sorted s) {
		return this.text.compareTo(s.text);
	}
	public int compare(Sorted s1, Sorted s2) {
		return s1.num - s2.num;
	}
}	

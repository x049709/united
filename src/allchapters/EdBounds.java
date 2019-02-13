package allchapters;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EdBounds {
	//Bounded parameter types
	//? (unbounded wildcard)
	//? extends Type (Type is the upper bound)
	//? super Type (Type is the lower bound)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> words = new ArrayList<>();
		words.add("Ed");
		words.add("Mike");
		NoBounds nb = new NoBounds();
		nb.printList(words);

		List<Integer> l = new ArrayList<Integer>();
		Integer z = new Integer("2");
		l.add(z);
		l.add(new Integer(42));
		UpBounds ub = new UpBounds();
		ub.printList(l);
		
		List<? super String> list = new ArrayList<String>();
		list.add("AA");
		LowBounds lb = new LowBounds();
		lb.printList(list);

		List<? super IOException> nums = new ArrayList<Exception>();
		nums.add(new IOException());
		nums.add(new FileNotFoundException());
		LowBounds numList = new LowBounds();
		numList.printNumbers(nums);;
	}

}

class NoBounds {
	public void printList(List<?> list) {
		for (Object x: list) {
			System.out.println(x);
		}
	}
}

class UpBounds {
	public void printList(List<? extends Number> list) {
		for (Number x: list) {
			System.out.println(x.longValue());
		}
	}
}

class LowBounds {
	public void printList(List<? super String> list) {
		for (Object x: list) {
			System.out.println(x);
		}
		
	}
	public void printNumbers(List<? super IOException> list) {
		for (Object x: list) {
			System.out.println(x);
		}
		
	}
}

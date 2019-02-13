package allchapters;

import java.util.function.Predicate;

public class EdLambda {

/*	public static void main(String[] args) {
		Strummable instrument = (String s) -> {System.out.println("strummed: " + s);};
		instrument.strum("instrument");
		Strummable guitar = s -> {System.out.println("strummed:" + s);};
		instrument.strum("guitar");
		IntStrummable violin = s -> 50;
		instrument.strum("violin");
	}

	@FunctionalInterface
	interface Strummable {
		void strum(String x);
	}

	@FunctionalInterface
	interface IntStrummable {
		int strum(String x);
	}
*/
	public void printHa (String inSt, Predicate<String> ha) {
		if (ha.test(inSt)) {
			System.out.println(inSt);
		} else {
			System.out.println("No!!!");
		}
	}
	public static void main(String[] args) {
		OneArgVoidReturn x = n -> {System.out.println(n);};
		x.foo("Yo");
		OneArgVoidReturn v = n -> System.out.println(n);
		v.foo("YoV");
		TwoArgsVoidReturn y = (s, i)->System.out.println("Yo "+s +" "+i); 
		y.foo("man",200);
		TwoArgsWithReturn z = (s,i) -> {return "Yoyo "+s +" "+i;};
		System.out.println(z.foo("joe", 2));
		TwoArgsWithReturn a = (s,i) -> {String f = "Yoyo "+s +" "+i;return f;};
		System.out.println(a.foo("moe", 212));
		Secret s = d -> "Poof";
		System.out.println(s.magic(2));
		new EdLambda().printHa("Joes",m -> m.contains("sx"));
		
		String s1 = new String("HELLO"); 
	    String s2 = new String("HELLO"); 
	    System.out.println("String == then equals"); 
	    System.out.println(s1 == s2); 
	    System.out.println(s1.equals(s2)); 
	  
		Object o1 = new Object(); 
		Object o2 = new Object(); 
	    System.out.println("Object == then equals"); 
	    System.out.println(o1 == o2); 
	    System.out.println(o1.equals(o2)); 
	  
		Object i1 = new Integer(3); 
		Object i2 = new Integer(3); 
	    System.out.println("Integer == then equals"); 
	    System.out.println(i1 == i2); 
	    System.out.println(i1.equals(i2)); 
	  
		
	}
	
}

interface OneArgVoidReturn {
	public void foo(String s);
}

interface TwoArgsVoidReturn {
	public void foo(String s, int i);
}

interface TwoArgsWithReturn {
	public String foo(String s, int i);
}

interface Secret {
	public String magic(double d);
}



interface Pred<T> {
	public boolean test(T t);
}

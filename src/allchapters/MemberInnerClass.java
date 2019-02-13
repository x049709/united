package allchapters;

import java.util.ArrayList;
import java.util.List;

import allchapters.Outie.Innie;

public class MemberInnerClass {

	private String greet = "Hi!";
	
	class Inner {
		int repeat = 3;
		void go() {
			System.out.println("---");
			for (int i=0;i<repeat;i++) {
				System.out.println(greet);
			}
		}
	}
	
	public void callInner () {
		Inner inner = new Inner();
		inner.go();
	}
	public static void main(String[] args) {
		//Method 1
		MemberInnerClass outer1 = new MemberInnerClass();
		outer1.callInner();
		//Method 2
		MemberInnerClass outer2 = new MemberInnerClass();
		Inner inner2 = outer2.new Inner();
		inner2.go();
		
		Outie o = new Outie();
		Innie i = o.new Innie();
		i.printX();
	}	
}

class Outie {
	
	int i=2;
	class Innie {
		int x=1;
		void printX () {
			System.out.println("Printing from Innie: " + x);
		}
	}
}

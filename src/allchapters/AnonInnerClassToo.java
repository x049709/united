package allchapters;

public class AnonInnerClassToo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InnerClassUtil iU = new InnerClassUtil();
		iU.runIt();
	}
}

abstract class ICClass {
	abstract void printMe ();
}

class InnerClassUtil {
	void runIt () {

		new ICClass() {
			void printMe() {
				int x = 2;
				System.out.println(x);
			}
		}.printMe();

		ICClass xw = new ICClass() {
			void printMe() {
				int x = 2;
				System.out.println(x);
			}
		};
		xw.printMe();
		
		class RealClass extends ICClass {
			void printMe() {System.out.println("XXXX");}
			void printMe(String a) {System.out.println("Hehe" + a);}
		}
		
		new RealClass().printMe();
		new RealClass().printMe("QQQQQ");
		
	}
}


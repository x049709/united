package allchapters;
public enum EnumToo {
	WINTER {
		public void printHours() {System.out.println("9am-3pm");}
	}, 
	SPRING {
		public void printHours() {System.out.println("9am-5pm");}
	},
	SUMMER {
		public void printHours() {System.out.println("9am-9pm");}
	},
	FALL {	
		public void printHours() {System.out.println("9am-6pm");}	
	};

	enum EnumAlso {
		A {
			public void printHours() {System.out.println("1am-3pm");}
		}, 
		B {
			public void printHours() {System.out.println("2am-5pm");}
		},
		C, D;
			public void printHours() {System.out.println("3am-9pm");}
		};

	public abstract void printHours();

	public static void main(String[] args) {	
		EnumToo s = EnumToo.WINTER;s.printHours();
		s = EnumToo.SPRING;s.printHours();
		s = EnumToo.FALL;s.printHours();
		s = EnumToo.SUMMER;s.printHours();
		
		EnumAlso t = EnumAlso.A;t.printHours();
		t = EnumAlso.B;t.printHours();
		t = EnumAlso.C;t.printHours();
		t = EnumAlso.D;t.printHours();

	}
}
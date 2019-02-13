package allchapters;

import java.io.IOException;
import java.sql.SQLException;

//Immutable class
class MultiCatch {
	
	public MultiCatch () {
	}
	//NO SETTERS
	
	public void runIt() {
		try {
			boolean isTrue=true;
			outer:
				for (int i=1;i<5;i++) {
					while (isTrue) {
						System.out.println("Hello");
						//continue outer; //print Hello 5 times
						break outer; //print Hello 1 time
					}
					System.out.println("Out of while");
					throw new IOException();
				}
			System.out.println("Out of for");
			throw new SQLException();
		}
		catch (SQLException | IOException e) {
			System.out.println("Exception");			
		}
		}
	
	
	public static void main(String[] args) {
		MultiCatch a1 = new MultiCatch();
		a1.runIt();
		System.out.println("Good bye");
	}

}
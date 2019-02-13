package allchapters;

//import java.io.IOException;
import java.sql.SQLException;
//AutoCloseables
class One implements AutoCloseable {
	public void close() {
		System.out.println("Close - One");
	}
}

class Two implements AutoCloseable {
	public Two(String s) {
		System.out.println("Open - Two " + s );		
	}
	public void close() {
		System.out.println("Close - Two ");
	}
}

public class EdCloseable {

	public static void main(String[] args) {
		try (Two two = new Two("First"); One one = new One();Two twotwo = new Two("Second") ) {
			//last resource defined will be closed first!!!
			System.out.println("Try");
			throw new SQLException();
		}
		catch (Exception ex) {
			System.out.println("Catch");
		}
		finally {
			System.out.println("Finally");
		}

	}

}

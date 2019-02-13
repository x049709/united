package allchapters;

import java.util.Map;
import java.util.function.BiConsumer;

public class EdBiConsumer {

	public static void main(String[] args) {
		BCMain bc = new BCMain();
		bc.runIt();
	}
}

class BCMain {
	public void runIt () {
		//takes two parms and returns nothing (method is 'accept')
		Map<String, String> env = System.getenv();
		BiConsumer<String, String> printEnv = (key, value) -> {
			System.out.println("Env key: " + value);	
		};
		printEnv.accept("USER", env.get("USER"));
	}
}

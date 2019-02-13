package allchapters;

import java.util.Optional;

public class EdOptionals {
	public static void main(String[] args) {
		OptionalUtils oU = new OptionalUtils();
		System.out.println(oU.ave(1,2,3,4,5));
		System.out.println(oU.ave());
		oU.checkAve(1,2,3,4,5);
		oU.checkAve();
	}	

}

class OptionalUtils {
	Optional<Double> ave(int... scores) {
		if (scores.length == 0) {
			return Optional.empty();
		}
		int sum = 0;
		for (int score: scores) {
			sum+=score;
		}
		return Optional.of((double)sum/scores.length);
	}
	
	void checkAve (int...scores) {
		Optional<Double> x = ave(scores);
		if (x.isPresent()) {
			System.out.println(x.get());
		} else System.out.println("Ouch");		
	}
}

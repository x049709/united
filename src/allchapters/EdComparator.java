package allchapters;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EdComparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Rabbit> rList = new ArrayList<>();
		rList.add(new Rabbit(12311));
		rList.add(new Rabbit(1555));
		rList.add(new Rabbit(22211));
		rList.add(new Rabbit(11111));
		rList.add(new Rabbit(71));
		rList.add(new Rabbit(811));
		rList.add(new Rabbit(7111));
		rList.add(new Rabbit(2111));
		rList.add(new Rabbit(555511));
		TreeSet<Rabbit> rSet = new TreeSet<>(rList);
		RabbitUtils rUtil = new RabbitUtils();
		Set<Rabbit> rSorted = rUtil.rabbitMethodSorter(rList);
		System.out.println("Sorted rabbit list");
		rUtil.rabbitPrinter(rSorted);
		System.out.println("Sorted rabbit set");
		rUtil.rabbitPrinter(rSet);
	}

}

class Rabbit implements Comparable<Rabbit> {
	private int id; 
	public Rabbit(int id) {
		this.id = id;	
	}
	public int getId () {
		return this.id;
	}
	
	public int compareTo(Rabbit r) {
		return this.getId() - r.getId();
	}
}	
class RabbitUtils {	
	Set<Rabbit> rabbitSorter (List<Rabbit> rabbits) {
		Comparator<Rabbit> cR = (Rabbit r1, Rabbit r2) -> {return r1.getId() - r2.getId();};
		Set<Rabbit> rB = new TreeSet<>(cR);
		for (Rabbit rabbit: rabbits) {
			rB.add(rabbit);
		}
		return rB;
	}
	
	void rabbitPrinter(Set<Rabbit> rabbits) {
		for (Rabbit rabbit: rabbits) {
			System.out.println("rabbit: " + rabbit.getId());
		}
	}

	Set<Rabbit> rabbitMethodSorter (List<Rabbit> rabbits) {
		
		
		Comparator<Rabbit> cR = (Rabbit r1, Rabbit r2) -> compareByMethod(r1, r2);
		Set<Rabbit> rB = new TreeSet<>(cR);
		for (Rabbit rabbit: rabbits) {
			rB.add(rabbit);
		}
		return rB;
	}
	
	private int compareByMethod (Rabbit r1, Rabbit r2) {
		return r1.getId() - r2.getId();
	}
	
}


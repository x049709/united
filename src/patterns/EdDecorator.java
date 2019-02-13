package patterns;

public class EdDecorator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecoratorTester dt = new DecoratorTester();
		dt.testBarista();

	}

}

class DecoratorTester {
	
	public void testBarista () {
		Beverage espresso = new Espresso();
		Beverage espressoWithMocha = new Mocha(espresso);
		Beverage espressoWithWhip = new Whip(espresso);
		Beverage espressoWithMochaAndWhip = new Whip(espressoWithMocha);
		System.out.println(espresso.getDescription() + " : " + espresso.calcCost());
		System.out.println(espressoWithMocha.getDescription() + " : " + espressoWithMocha.calcCost());
		System.out.println(espressoWithWhip.getDescription() + " : " + espressoWithWhip.calcCost());
		System.out.println(espressoWithMochaAndWhip.getDescription() + ":" + espressoWithMochaAndWhip.calcCost());
		
	}
}

abstract class Beverage {
	protected String description = "Unknown";
	public abstract double calcCost();
	public abstract String getDescription();		
}

abstract class CondimentAdder extends Beverage {
	public abstract double calcCost();
	public abstract String getDescription();			
}

class Espresso extends Beverage {
	public Espresso() {
		description = "Espresso";
	}
	public String getDescription () {
		return description;
	}
	public double calcCost() {
		return 1.99;
	}
}

class HouseBlend extends Beverage {
	public HouseBlend() {
		description = "House Blend";
	}
	public String getDescription () {
		return description;
	}
	public double calcCost() {
		return 0.99;
	}
}

class Mocha extends CondimentAdder {
	Beverage beverage;
	
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public String getDescription() {
		return beverage.getDescription() + " + mocha ";
	}
	
	public double calcCost() {
		return beverage.calcCost() + 0.20;
	}
}

class Whip extends CondimentAdder {
	Beverage beverage;
	
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public String getDescription() {
		return beverage.getDescription() + " + whip ";
	}
	
	public double calcCost() {
		return beverage.calcCost() + 0.25;
	}
}
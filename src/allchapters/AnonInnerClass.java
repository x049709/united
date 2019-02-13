package allchapters;

public class AnonInnerClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnonInnerClass x = new AnonInnerClass();
		System.out.println(x.salePriceOne(200));
		System.out.println(new AnonInnerClass().salePriceOne(300));
		System.out.println(new AnonInnerClass().salePriceTwo(400));
		System.out.println(new AnonInnerClass().salePriceThree(500));
	}

	abstract class SaleToday {
		abstract int dollarsOff();
	}
	//SalePrice is an anonymous inner class
	public int salePriceOne(int basePrice) {
		//SaleToday 's' is a local variable that contains an anonymous inner class
		SaleToday s = new SaleToday () {
			int dollarsOff () {
				return 3;
			}
		};
		return basePrice - s.dollarsOff();
	}
	
	//SalePrice is an anonymous inner class
	public int salePriceTwo(int basePrice) {
		return calcPrice(basePrice, new SaleToday() {public int dollarsOff() {return 3;}});
	}
	
	int calcPrice(int basePrice, SaleToday sale) {
		return basePrice - sale.dollarsOff();
	}
		
	//SalePrice is an anonymous inner class
	public int salePriceThree(int basePrice) {
		//All in one line
		return basePrice - new SaleToday () {int dollarsOff () {return 3;}}.dollarsOff();
	}
	
}

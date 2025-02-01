package DecoratorPattern;

public class Esspresso extends Beverage {
	
	public Esspresso() {
		description = "에스프레소";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 1.99;
	}

}

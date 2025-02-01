package DecoratorPattern;

public class DeCaf extends Beverage {
	
	public DeCaf() {
		description = "디카페인";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 1.05;
	}

}

package DecoratorPattern;

public class Whip extends Decoration {
	
	public Whip (Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + ", »÷«Œ≈©∏≤";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return beverage.cost() + .10;
	}

}

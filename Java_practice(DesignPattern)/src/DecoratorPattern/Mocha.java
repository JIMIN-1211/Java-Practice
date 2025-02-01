package DecoratorPattern;

public class Mocha extends Decoration {

	public Mocha (Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + ", ¸ğÄ«";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return beverage.cost() + .20;
	}

}

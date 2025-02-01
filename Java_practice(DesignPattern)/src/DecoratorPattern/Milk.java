package DecoratorPattern;

public class Milk extends Decoration {
	
	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + ", ¿ìÀ¯";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return beverage.cost() + .10;
	}

}

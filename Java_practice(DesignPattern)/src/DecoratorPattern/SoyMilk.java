package DecoratorPattern;

public class SoyMilk extends Decoration {
	
	public SoyMilk(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + ", µŒ¿Ø";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return beverage.cost() + .15;
	}

}

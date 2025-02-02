package DecoratorPattern;

import DecoratorPattern.Beverage.Size;

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
		double cost = beverage.cost();
		if(beverage.getSize() == Size.TALL) {
			cost += .10;
		}else if(beverage.getSize() == Size.GRANDE) {
			cost += .15;
		}else if(beverage.getSize() == Size.VENTI) {
			cost += .20;
		}
		return cost;
	}

}

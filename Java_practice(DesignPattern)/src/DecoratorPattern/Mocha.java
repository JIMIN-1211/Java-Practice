package DecoratorPattern;

import DecoratorPattern.Beverage.Size;

public class Mocha extends Decoration {

	public Mocha (Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + ", ¸ðÄ«";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		double cost = beverage.cost();
		if(beverage.getSize() == Size.TALL) {
			cost += .15;
		}else if(beverage.getSize() == Size.GRANDE) {
			cost += .20;
		}else if(beverage.getSize() == Size.VENTI) {
			cost += .25;
		}
		return cost;
	}

}

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
		double cost = beverage.cost();
		if(beverage.getSize() == Size.TALL) {
			cost += .05;
		}else if(beverage.getSize() == Size.GRANDE) {
			cost += .10;
		}else if(beverage.getSize() == Size.VENTI){
			cost += .15;
		}
		return cost;
	}

}

package DecoratorPattern;

import DecoratorPattern.Beverage.Size;

public class Milk extends Decoration {
	
	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + ", 우유";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		double cost = beverage.cost();
		if(beverage.getSize() == Size.TALL) { //그냥 getSize()라고 해도 코드는 실행되지만, 명시적으로 현재 장식하고자 하는 객체의 사이즈를 가져오라는 코드이다. 
			cost += .05;
		}else if(beverage.getSize() == Size.GRANDE) {
			cost+= .10;
		}else if(beverage.getSize() == Size.VENTI) {
			cost+= .15;
		}
		return cost;
	}

}

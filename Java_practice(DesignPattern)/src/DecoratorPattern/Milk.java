package DecoratorPattern;

import DecoratorPattern.Beverage.Size;

public class Milk extends Decoration {
	
	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + ", ����";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		double cost = beverage.cost();
		if(beverage.getSize() == Size.TALL) { //�׳� getSize()��� �ص� �ڵ�� ���������, ��������� ���� ����ϰ��� �ϴ� ��ü�� ����� ��������� �ڵ��̴�. 
			cost += .05;
		}else if(beverage.getSize() == Size.GRANDE) {
			cost+= .10;
		}else if(beverage.getSize() == Size.VENTI) {
			cost+= .15;
		}
		return cost;
	}

}

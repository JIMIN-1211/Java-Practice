package DecoratorPattern;

public class DeCaf extends Beverage {
	
	public DeCaf() {
		description = "��ī����";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 1.05;
	}

}

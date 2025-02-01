package DecoratorPattern;

public class HouseBlend extends Beverage {
	
	public HouseBlend() {
		// TODO Auto-generated constructor stub
		description = "하우스 블렌드";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return .89;
	}

}

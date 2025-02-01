package DecoratorPattern;

public class DarkRoast extends Beverage {
	
	public DarkRoast() {
		description = "다크 로스트";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return .99;
	}

}

package DecoratorPattern;

public abstract class Decoration extends Beverage {
	Beverage beverage;

	public abstract String getDescription();
	//Beverage클래스의 일반 메서드를 추상메서드로 오버라이딩
	
}

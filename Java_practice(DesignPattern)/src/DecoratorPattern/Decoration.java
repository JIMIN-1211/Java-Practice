package DecoratorPattern;

public abstract class Decoration extends Beverage {
	Beverage beverage;

	public abstract String getDescription();
	//Beverage클래스의 일반 메서드를 추상메서드로 오버라이딩

	@Override
	public Size getSize() {
		// TODO Auto-generated method stub
		return beverage.getSize(); //여기서의 beverage는 나중에 토핑클래스가 상속 받더라도 그냥 현재 참조하고 있는 beverage객체의 사이즈를 가져오는 값을 리턴하라는 의미이다. 
	}
	
}

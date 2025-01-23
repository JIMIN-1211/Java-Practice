package StrategyPattern;

public interface FlyBehavior {
	public void fly();
}
//인터페이스에서 추상 메서드를 선언할 때는 ‘abstract’ 키워드를 명시적으로 붙이지 않아도 자동으로 추상 메서드로 간주된다. 
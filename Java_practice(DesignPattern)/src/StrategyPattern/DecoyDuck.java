package StrategyPattern;

public class DecoyDuck extends Duck {
	public DecoyDuck() {
		// TODO Auto-generated constructor stub
		flyBehavior = new FlyNoWay();
		quackBehavior = new MuteQuack();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("저는 모형 오리에요!");
	}

}

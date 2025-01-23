package StrategyPattern;

public class RubberDuck extends Duck {
	public RubberDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Squeak();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("���� ����������!");
	}

}

package StrategyPattern;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("저는 못 날아요!");
	}

}

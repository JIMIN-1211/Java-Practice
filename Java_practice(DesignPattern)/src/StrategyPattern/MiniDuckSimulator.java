package StrategyPattern;

public class MiniDuckSimulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Duck mallardDuck = new MallardDuck();
		Duck rubberDuck = new RubberDuck();
		Duck decoyDuck = new DecoyDuck();
		
		mallardDuck.display();
		mallardDuck.performFly();
		mallardDuck.performQuack();
		
		System.out.println("============================");
		
		rubberDuck.display();
		rubberDuck.performFly();
		rubberDuck.performQuack();
		
		System.out.println("============================");
		
		decoyDuck.display();
		decoyDuck.performFly();
		decoyDuck.performQuack();
		
		System.out.println("============================");
	}

}

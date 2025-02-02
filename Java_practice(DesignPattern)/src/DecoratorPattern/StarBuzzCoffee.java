package DecoratorPattern;

import DecoratorPattern.Beverage.Size;

public class StarBuzzCoffee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Beverage beverage1 = new DarkRoast();
		beverage1.setSize(Size.TALL);
		beverage1 = new Milk(beverage1);
		beverage1 = new Mocha(beverage1);
		
		System.out.println(beverage1.getDescription());
		System.out.println("$"+beverage1.cost());
		
		System.out.println("===================");
		
		Beverage beverage2 = new HouseBlend();
		beverage2.setSize(Size.TALL);
		beverage2 = new SoyMilk(beverage2);
		beverage2 = new Whip(beverage2);
		
		System.out.println(beverage2.getDescription());
		System.out.println("$"+beverage2.cost());
		
		System.out.println("===================");
	}

}

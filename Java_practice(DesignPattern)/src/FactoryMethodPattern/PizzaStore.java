package FactoryMethodPattern;

public abstract class PizzaStore {
	
	public Pizza OrderPizza(String type) {
		Pizza pizza;
		
		pizza = CreatePizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}
	
	public abstract Pizza CreatePizza(String type);

}


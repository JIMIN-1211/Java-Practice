package AbstractFactoryMethodPattern;

public abstract class PizzaStore {
	
	public Pizza orderPizza(String item) {
		Pizza pizza = CreatePizza(item);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}
	
	public abstract Pizza CreatePizza(String item);
}

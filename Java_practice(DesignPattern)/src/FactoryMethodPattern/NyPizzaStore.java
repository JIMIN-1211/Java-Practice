package FactoryMethodPattern;

public class NyPizzaStore extends PizzaStore {

	@Override
	public Pizza CreatePizza(String type) {
		// TODO Auto-generated method stub
		if(type.equals("cheese")) {
			return new NyStyleCheesePizza();
		}else {
			return new NyStylePepperoniPizza();
		}
	}

}


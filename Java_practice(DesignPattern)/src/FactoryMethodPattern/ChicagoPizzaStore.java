package FactoryMethodPattern;

public class ChicagoPizzaStore extends PizzaStore {

	@Override
	public Pizza CreatePizza(String type) {
		// TODO Auto-generated method stub
		if(type.equals("Cheese")) {
			return new ChicagoStyleCheesePizza();
		}else {
			return new ChicagoStylePepperoniPizza();
		}
	}

}

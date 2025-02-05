package AbstractFactoryMethodPattern;

public class NYPizzaStore extends PizzaStore {

	@Override
	public Pizza CreatePizza(String item) {
		// TODO Auto-generated method stub
		Pizza pizza = null;
		PizzaIngredientFactory nyPizzaIngredientFactory = new NYPizzaIngredientFactory();
		
		if(item.equals("cheese")) {
			Veggies selected[] = {new Garlic()};
			
			pizza = new CheesePizza(nyPizzaIngredientFactory, selected);
			pizza.setName("뉴욕 치즈 피자");
			
		}else if(item.equals("pepperoni")) {
			Veggies selected[] = {new Mushroom(), new Onion(), new RedPepper()};
			
			pizza = new PepperoniPizza(nyPizzaIngredientFactory, selected);
			pizza.setName("뉴욕 페퍼로니 피자");
			
		}else if(item.equals("veggie")) {
			Veggies selected[] = {new Mushroom(), new Onion(), new RedPepper()};
			
			pizza = new VeggiePizza(nyPizzaIngredientFactory, selected);
			pizza.setName("뉴욕 야채 피자");
		}else if(item.equals("clam")) {
			Veggies selected[] = {};
			
			pizza = new VeggiePizza(nyPizzaIngredientFactory, selected);
			pizza.setName("뉴욕 조개 피자");
		}
		
		return pizza;
	}

}

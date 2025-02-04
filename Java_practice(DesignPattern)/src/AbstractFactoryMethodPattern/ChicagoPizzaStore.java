package AbstractFactoryMethodPattern;

public class ChicagoPizzaStore extends PizzaStore {

	@Override
	public Pizza CreatePizza(String item) {
		// TODO Auto-generated method stub
		Pizza pizza = null;
		PizzaIngredientFactory chicagoPizzaIngredientFactory = new ChicagoPizzaIngredientFactory();
		
		if(item.equals("chees")) {
			Veggies selected[] = {new Oregano()};
			
			pizza = new CheesePizza(chicagoPizzaIngredientFactory, selected);
			pizza.setName("시카고 치즈 피자");
			
		}else if(item.equals("pepperoni")) {
			Veggies selected[] = {new EggPlant(), new Spinach(), new BlackOlive()};
			
			pizza = new PepperoniPizza(chicagoPizzaIngredientFactory, selected);
			pizza.setName("시카고 페퍼로니 피자");
			
		}else if(item.equals("veggie")) {
			Veggies selected[] = {new EggPlant(), new Spinach(), new BlackOlive()};
			
			pizza = new VeggiePizza(chicagoPizzaIngredientFactory, selected);
			pizza.setName("시카고 야채 피자");
		}else if(item.equals("clam")) {
			Veggies selected[] = {};
			
			pizza = new VeggiePizza(chicagoPizzaIngredientFactory, selected);
			pizza.setName("시카고 조개 피자");
		}
		
		return pizza;
		
	}

}

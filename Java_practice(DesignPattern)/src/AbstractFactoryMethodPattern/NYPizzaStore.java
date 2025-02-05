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
			pizza.setName("���� ġ�� ����");
			
		}else if(item.equals("pepperoni")) {
			Veggies selected[] = {new Mushroom(), new Onion(), new RedPepper()};
			
			pizza = new PepperoniPizza(nyPizzaIngredientFactory, selected);
			pizza.setName("���� ���۷δ� ����");
			
		}else if(item.equals("veggie")) {
			Veggies selected[] = {new Mushroom(), new Onion(), new RedPepper()};
			
			pizza = new VeggiePizza(nyPizzaIngredientFactory, selected);
			pizza.setName("���� ��ä ����");
		}else if(item.equals("clam")) {
			Veggies selected[] = {};
			
			pizza = new VeggiePizza(nyPizzaIngredientFactory, selected);
			pizza.setName("���� ���� ����");
		}
		
		return pizza;
	}

}

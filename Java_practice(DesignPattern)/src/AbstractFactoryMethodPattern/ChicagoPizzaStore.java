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
			pizza.setName("��ī�� ġ�� ����");
			
		}else if(item.equals("pepperoni")) {
			Veggies selected[] = {new EggPlant(), new Spinach(), new BlackOlive()};
			
			pizza = new PepperoniPizza(chicagoPizzaIngredientFactory, selected);
			pizza.setName("��ī�� ���۷δ� ����");
			
		}else if(item.equals("veggie")) {
			Veggies selected[] = {new EggPlant(), new Spinach(), new BlackOlive()};
			
			pizza = new VeggiePizza(chicagoPizzaIngredientFactory, selected);
			pizza.setName("��ī�� ��ä ����");
		}else if(item.equals("clam")) {
			Veggies selected[] = {};
			
			pizza = new VeggiePizza(chicagoPizzaIngredientFactory, selected);
			pizza.setName("��ī�� ���� ����");
		}
		
		return pizza;
		
	}

}

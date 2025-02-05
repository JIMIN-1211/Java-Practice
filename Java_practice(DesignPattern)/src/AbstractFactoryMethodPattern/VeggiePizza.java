package AbstractFactoryMethodPattern;

public class VeggiePizza extends Pizza {
	PizzaIngredientFactory pizzaIngredientFactory;
	Veggies selectedVeggies[];
	
	public VeggiePizza(PizzaIngredientFactory pizzaIngredientFactory, Veggies selected[]) {
		this.pizzaIngredientFactory = pizzaIngredientFactory;
		this.selectedVeggies = selected;
	}

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		System.out.println("준비 중 : " + name);
		
		dough = pizzaIngredientFactory.createDough();
		sauce = pizzaIngredientFactory.createSauce();
		cheese = pizzaIngredientFactory.createCheese();
		veggies = pizzaIngredientFactory.createVeggies(selectedVeggies);

		System.out.print("재료 : "+dough+", "+sauce);
		for(Cheese cheese : cheese) {
			System.out.print(", ");
			System.out.print(cheese);
		}
		for(Veggies veggie : veggies) {
			System.out.print(", ");
			System.out.print(veggie);
			
		}
		System.out.println("");
	}

}

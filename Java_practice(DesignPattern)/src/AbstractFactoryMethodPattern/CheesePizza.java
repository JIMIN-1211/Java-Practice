package AbstractFactoryMethodPattern;

public class CheesePizza extends Pizza {
	
	PizzaIngredientFactory pizzaIngredientFactory;
	Veggies selectedVeggies[];
	
	public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory, Veggies selected[]) {
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
		
		System.out.print("재료 : "+dough+", "+sauce+", "+cheese+", ");
		for(Veggies veggie : veggies) {
			System.out.print(veggie);
			System.out.print(", ");
		}
		
	}

}

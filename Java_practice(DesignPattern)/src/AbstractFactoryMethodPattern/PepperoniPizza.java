package AbstractFactoryMethodPattern;

public class PepperoniPizza extends Pizza {
	PizzaIngredientFactory pizzaIngredientFactory;
	Veggies selectedVeggies[];
	
	public PepperoniPizza(PizzaIngredientFactory pizzaIngredientFactory, Veggies selected[]) {
		// TODO Auto-generated constructor stub
		this.pizzaIngredientFactory = pizzaIngredientFactory;
		this.selectedVeggies = selected;
	}

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		System.out.println("�غ� �� : " + name);
		
		dough = pizzaIngredientFactory.createDough();
		sauce = pizzaIngredientFactory.createSauce();
		cheese = pizzaIngredientFactory.createCheese();
		veggies = pizzaIngredientFactory.createVeggies(selectedVeggies);
		pepperoni = pizzaIngredientFactory.createPepperoni();

		System.out.print("��� : "+dough+", "+sauce+", "+pepperoni);
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

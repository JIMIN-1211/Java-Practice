package AbstractFactoryMethodPattern;

public class ClamPizza extends Pizza {
	PizzaIngredientFactory pizzaIngredientFactory;
	Veggies selectedVeggies[];
	
	public ClamPizza(PizzaIngredientFactory pizzaIngredientFactory, Veggies selected[]){
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
		clam = pizzaIngredientFactory.createClams();

		System.out.print("재료 : "+dough+", "+sauce+", "+clam);
		for(Cheese cheese : cheese) {
			System.out.print(", ");
			System.out.print(cheese);
		}
		System.out.println("");
		
	}

}

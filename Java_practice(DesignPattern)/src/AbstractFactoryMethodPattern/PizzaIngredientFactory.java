package AbstractFactoryMethodPattern;

public interface PizzaIngredientFactory {
	
	public Dough createDough();
	public Sauce createSauce();
	public Cheese[] createCheese();
	public Veggies[] createVeggies(Veggies[] selectedVeggies);
	public Pepperoni createPepperoni();
	public Clams createClams();
}

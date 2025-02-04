package AbstractFactoryMethodPattern;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		// TODO Auto-generated method stub
		return new ThickDough();
	}

	@Override
	public Sauce createSauce() {
		// TODO Auto-generated method stub
		return new PlumTomatoSauce();
	}

	@Override
	public Cheese[] createCheese() {
		// TODO Auto-generated method stub
		Cheese cheese[] = {new MozzarellaCheese(), new ParmesanCheese()}; 
		return cheese;
	}

	@Override
	public Veggies[] createVeggies(Veggies[] selectedVeggies) {
		// TODO Auto-generated method stub
		return selectedVeggies;
	}

	@Override
	public Pepperoni createPepperoni() {
		// TODO Auto-generated method stub
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClams() {
		// TODO Auto-generated method stub
		return new FrozenClams();
	}

	

}

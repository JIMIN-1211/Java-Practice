package AbstractFactoryMethodPattern;

public class PizzaTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore chicagoStore = new ChicagoPizzaStore();
		Pizza pizza;
		
		pizza = nyStore.orderPizza("cheese");
		System.out.println(pizza.getName()+" 완성!");
		
		pizza = chicagoStore.orderPizza("cheese");
		System.out.println(pizza.getName()+" 완성");
		
	}

}

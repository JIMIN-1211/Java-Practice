package FactoryMethodPattern;

public class PizzaTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 PizzaStore nyPizzaStore = new NyPizzaStore(); //다형성을 이용해 동일한코드(하나의 메서드)로 다양한 타입의 객체를 처리하기 위해서 할당
		 PizzaStore chicagoPizzaStore = new ChicagoPizzaStore(); //다형성을 이용해 동일한코드(하나의 메서드)로 다양한 타입의 객체를 처리하기 위해서 할당
		 
		 nyPizzaStore.OrderPizza("cheese");
		 System.out.println("");
		 nyPizzaStore.OrderPizza("pepperoni");
		 System.out.println("");
		 
		 chicagoPizzaStore.OrderPizza("cheese");
		 System.out.println("");
		 chicagoPizzaStore.OrderPizza("pepperoni");
	}

}

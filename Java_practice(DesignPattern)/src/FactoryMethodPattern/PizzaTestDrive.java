package FactoryMethodPattern;

public class PizzaTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 PizzaStore nyPizzaStore = new NyPizzaStore(); //�������� �̿��� �������ڵ�(�ϳ��� �޼���)�� �پ��� Ÿ���� ��ü�� ó���ϱ� ���ؼ� �Ҵ�
		 PizzaStore chicagoPizzaStore = new ChicagoPizzaStore(); //�������� �̿��� �������ڵ�(�ϳ��� �޼���)�� �پ��� Ÿ���� ��ü�� ó���ϱ� ���ؼ� �Ҵ�
		 
		 nyPizzaStore.OrderPizza("cheese");
		 System.out.println("");
		 nyPizzaStore.OrderPizza("pepperoni");
		 System.out.println("");
		 
		 chicagoPizzaStore.OrderPizza("cheese");
		 System.out.println("");
		 chicagoPizzaStore.OrderPizza("pepperoni");
	}

}

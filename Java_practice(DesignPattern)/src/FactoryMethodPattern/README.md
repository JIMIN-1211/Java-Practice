# PizzaFactory
## ������Ʈ ����
������ ���� ��Ÿ���� �ٸ� ���ڸ� �����ϴ� ���α׷��̴�.

## ��� ����
- Java

## ��ġ �� ����
1. ��ġ ���


	```bash
	git clone https://github.com/JIMIN-1211/FactoryMethodPattern.git
	cd FactoryMethodPattern

## �ֿ� ���
- ���� ��Ÿ�� ���ڸ� �ֹ��ϰ� ������ �ش� �������� ���ڸ� �ֹ��ϸ� ġ�� ���ڸ� �ֹ��ϴ��� ����� ���ڸ� ���� �������ش�. 
- �ï��� ��Ÿ�� ���� ���� �ֹ��� �����ϴ�. 

## ���� �ذ� ����
### 1. ���� Ŭ������ ���� Ŭ������ ������
���� Ŭ���� : �θ� Ŭ������ ��ɸ� �����ϰ� ����� �Ұ��ϴ�.   

���� Ŭ���� : �θ� Ŭ������ ��� Ȯ�� / �����ϰ� ����� �����ϴ�. 

### 2. ���丮 �޼���
	�� �ڵ忡�� �� �� ���� �ν��Ͻ��� ������ ��� ���� ������ ���� �ν��Ͻ��� �����ϰ� �����ؾ��ϴ� ��� ������ pizzaStore�� �ڵ带 �Ź� ����������Ѵ�. 
	
		```Java
		public class PizzaStore {
			public Pizza OrderPizza(String type) {
				Pizza pizza;
				
				if(type.equals("cheese"){
					pizza = new CheesePizza(); //�̺κ�
				}else if(type.equals("pepperoni"){
					pizza = new pepperoniPizza(); //�̺κ�
				}
			}
		}
	
	�׷��� �̷� ��ȭ�Ǵ� �κ��� **ĸ��ȭ** �ؼ� ��ü ������ ����� �и��Ѵ�. 
	
	�׸��� �̷��� ��ü �����κ��� �������̽� �Ǵ� �߻�Ŭ������ �߻� �޼���� ���丮 �޼��带 �����ϰ�   
	�̰� ��ӹ��� '����Ŭ����'�� ���� ��ü�� �����ϴ� ����� �������� ������ �� �ִ�. 
	
		```Java
		public abstract class PizzaStore {
	
			public Pizza OrderPizza(String type) {
				Pizza pizza;
				
				pizza = CreatePizza(type);
				
				pizza.prepare();
				pizza.bake();
				pizza.cut();
				pizza.box();
				
				return pizza;
			}
			
			public abstract Pizza CreatePizza(String type);//���丮 �޼���
		
		}
		//����Ŭ����
		public class NyPizzaStore extends PizzaStore {
		
			@Override
			public Pizza CreatePizza(String type) {
				// TODO Auto-generated method stub
				if(type.equals("cheese")) {
					return new NyStyleCheesePizza();
				}else {
					return new NyStylePepperoniPizza();
				}
			}
		
		}
		//����Ŭ����
		public class ChicagoPizzaStore extends PizzaStore {
		
			@Override
			public Pizza CreatePizza(String type) {
				// TODO Auto-generated method stub
				if(type.equals("Cheese")) {
					return new ChicagoStyleCheesePizza();
				}else {
					return new ChicagoStylePepperoniPizza();
				}
			}
			
		}
		
		
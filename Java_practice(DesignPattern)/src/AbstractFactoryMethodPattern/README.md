# PizzaFactory 2.0
## ������Ʈ ����
���� ���� ���丮 ���α׷����� ����Ŭ���� �������� �� ���缭 �������� Ȯ�强�� ���� ���� ���丮 ���α׷��̴�. 

## ��� ����
- Java

## ��ġ �� ����
1. ��ġ ���


	```bash
	git clone https://github.com/JIMIN-1211/DecoratorPattern.git
	cd DecoratorPattern

## �ֿ� ���
- �������� �ٸ� ��Ḧ ����Ͽ� ���ڸ� ����� ������, �� ������ ������ ���� ��Ḧ ��ü������ �����ش�.
- �������� �ٸ� ���� ���ڸ� �ֹ��ϴ��� �ٸ� ���ڸ� ����� �ش�. 

## ���� �ذ� ����
### 1. ���� ������ �´� ����ᱺ�� ����
�߻� ���丮��(�������̽� / �߻�Ŭ����) ��ǰ���� �����ϴ� �������̽��� ������ �� �ִ�. 
	
	```Java
	//�������̽� ����(��ü���� �߻� ����� ����)
	public interface PizzaIngredientFactory {
	
		public Dough createDough();					//���丮 �޼���
		public Sauce createSauce();					//���丮 �޼���
		public Cheese[] createCheese();				//���丮 �޼���
		public Veggies[] createVeggies(Veggies[] selectedVeggies);	//���丮 �޼���
		public Pepperoni createPepperoni();				//���丮 �޼���
		public Clams createClams();					//���丮 �޼���
	}
	//���� Ŭ���� (��������)
	public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
	
		@Override
		public Dough createDough() {
			// TODO Auto-generated method stub
			return new ThinDough();
		}
	
		@Override
		public Sauce createSauce() {
			// TODO Auto-generated method stub
			return new MarinaraSauce();
		}
	
		@Override
		public Cheese[] createCheese() {
			// TODO Auto-generated method stub
			Cheese cheese[] = {new ReggianoCheese()};
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
			return new FreshClams();
		}
	
	�̷��� �����ν� ����, �ü��, ����� �� ���� �ٸ� ��Ȳ�� �´� ��ǰ�� �����ϴ� ���丮�� ������ �� �ִ�. 
	
### 2. �ʿ��� ä�����鸸 �غ��Ѵ�. 
���� �޴����� �ʿ���ϴ� ä�ҵ��� �ٸ��� ����, �������� ���ڰ��Կ��� �ʿ��� ä�ҵ鸸 �����ؼ� ���ڸ� �����. 
  
ó���� ���� �������� ����ϴ� ä�ҵ��� ���丮�޼��� ����Ŭ���� �� 'NYPizzaIngredientFactory'Ŭ�������� ������ ����,   
�ʿ��� ä�ҵ鸸 �� ���� �޴����� ������ �����̾���.   

�׷��� ���� ���ʿ��� ��� ä�ұ��� ��ȯ�� ���� �ٽ� ���͸��� �ϴ� �۾��� �ڵ��� ȿ������ �������� �� ����, �׳� ���ڰ��Կ��� �ʿ��� ä�Ҹ� �����ϴ� �����ڸ� �����ϴ� ���·� �����Ͽ���. 

	```Java
	public interface PizzaIngredientFactory {
	
		public Dough createDough();
		public Sauce createSauce();
		public Cheese[] createCheese();
		
		public Veggies[] createVeggies(Veggies[] selectedVeggies);		//�ʿ��� ä�Ҹ� �����ϴ� ������ �����ϴ� ���丮 �޼���
		
		public Pepperoni createPepperoni();
		public Clams createClams();
	}
	//����Ŭ����
	public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
		@Override
		public Veggies[] createVeggies(Veggies[] selectedVeggies) {
			// TODO Auto-generated method stub
			return selectedVeggies; //�ʿ��� ä�Ҹ� ������ VeggiesŸ�� selectedVeggies�迭 ��ȯ
		}
	}
	//���ڷ�����
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
			
			System.out.println("�غ� �� : " + name);
			
			dough = pizzaIngredientFactory.createDough();
			sauce = pizzaIngredientFactory.createSauce();
			cheese = pizzaIngredientFactory.createCheese();
			veggies = pizzaIngredientFactory.createVeggies(selectedVeggies); //�ʿ��� ä�Ҹ� ����
			
			System.out.print("��� : "+dough+", "+sauce);
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
	
���������� �ʿ��� ä�Ҹ� setter�� ������ �� ���� �ʳ���� ������ �ؼ� chatGPT���� �����

���ʿ��� �ܺ� ������: setter�� ����ϸ� Pizza Ŭ������ ���� ����(ä�� ��)�� �ܺο��� ������ �� �ְ� �˴ϴ�. �̴� ��ü�� ���¸� �Ҿ����ϰ� ���� �� ������, �ǵ����� ���� ���� �� ���ɼ��� �����մϴ�.

�ҿ����� ��ü ����: Pizza ��ü�� ������ �������� ���� ���¿��� �ܺο��� veggies�� �����Ѵٸ�, �� ��ü�� ���������� ������ �� �ֽ��ϴ�. ���� ���, Pizza�� prepare() �޼��忡�� veggies�� �����Ǳ� ���� prepare()�� ȣ��� ��� veggies ���� null�� �� �� �ֽ��ϴ�.

���丮 �޼����� ���� ���: ���丮 �޼��� ���Ͽ����� ��ü ���� ������ ĸ��ȭ�Ǿ�� �ϹǷ�, �ܺο��� setter�� ���� ä�Ҹ� �����ϴ� ����� ���� Ŭ������ �������� �������� ������ ������ ���� �ʽ��ϴ�.

�̷� ������ ������ �� ��ȿ������ �ڵ尡 �� �� �ִٴ� ����� ���ȴ�. 



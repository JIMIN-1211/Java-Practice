# StarBuzz Coffee
## ������Ʈ ����
���ϴ� ���� ������ �����ϰ� ������ �ֹ��ϸ� ���Ḧ �����ϰ�, ������ִ� ���α׷��̴�. 

## ��� ����
- Java

## ��ġ �� ����
1. ��ġ ���


	```bash
	git clone https://github.com/JIMIN-1211/DecoratorPattern.git
	cd DecoratorPattern

## �ֿ� ���
- ���ϴ� ���Ḧ �ֹ��ϰ�, ���� ����� �� �ִ�. 

## ���� �ذ� ����
### 1. ��ӹ��� �Ϲݸ޼����� �߻�ȭ
������ �߰��� ��� ���θ��� �߰�������, ��� ��� �޼���� �״�� ����ϱ� ����

Decoration �߻� Ŭ������ Beverage �߻�Ŭ������ ����ؼ� getDescription()�Ϲ� �޼��带 �߻�ȭ �ߴ�. 

	```Java
	public abstract class Decoration extends Beverage {
		Beverage beverage;
	
		public abstract String getDescription();
		//BeverageŬ������ �Ϲ� �޼��带 �߻�޼���� �������̵�
		
	}

__�Ϲ� �޼���� ���������� �������̵� �����ϹǷ�, �Ϲ� �޼��带 �߻�ȭ�����ν� ������ �����ϴ� ����̴�.__

__Why?__
- Beverage�߻�Ŭ���� �������� ��� ���� ���� Ŭ������ ������� ��ȯ�ϴ� getDescription()�޼��带 ȣ���ؼ� ���θ� �߰��ϴ� �ڵ�� �����ϱ� ���ؼ� 

### 2. ��ü�� �߰� ��Ҹ� �������� ���ϱ�
������ �߰��� Beverage�ν��Ͻ��� DecorationŬ������ Beverage�ν��Ͻ��� �Ҵ��ϴ� ������ �ڵ带 �ۼ��Ѵ�.

__�̸� ���� �޼��带 ȣ���Ͽ� ��ü���� � �ൿ�� �����ϰų� �߰��۾��� �����ϵ��� �Ѵ�.__

�� ���� ��Ҹ� �߰��ϰų�, ���� ���� ��Ҹ� �߰��ϴ� �۾��� �����ϵ��� �� �� �ִ�. 

	```Java
	public class Milk extends Decoration {
	
	public Milk(Beverage beverage) { // beverage ==> �߰��ϰ��� �ϴ� ���������� �����ϰ� �ִ� �ν��Ͻ� 
		this.beverage = beverage;    // this.beverage ==> DecorationŬ������ BeverageŸ�� �ν��Ͻ�
	}				// ������ �߰��� ���Ḧ �ν��Ͻ��� �Ҵ��ϵ��� �ϴ� ������
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + ", ����";
	}//�߻�ȭ�ߴ� getDescription()�޼��忡�� ������ description ��ü�� '����'���� ��Ҹ� �������� �߰� �����ϴ�.
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return beverage.cost() + .10;
	}//�߻�ȭ���� �ʾ����� �������� ���� ��Ҹ� �߰��Ͽ� ��� ��Ű�� cost()�޼���� ����

}
### 3. ������
	�θ� Ŭ������ 'Beverage'Ÿ���� ���� ������ beverage1�� �ڽ�Ŭ������ 'Houseblend'��  �����ϵ��� �Ҵ��ϴ� ������   
	� Ÿ��(���� �Ǵ� ����)�̵��� ��� ���� Beverage�� ����ϰ� �ִ� Ŭ������ getDescription()�޼���� cost()�޼��带 ����ϱ� ���ؼ��̴�. 
	
	public class StarBuzzCoffee {
	
	public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			Beverage beverage2 = new HouseBlend();
			beverage2 = new SoyMilk(beverage2);
			beverage2 = new Whip(beverage2);
			System.out.println(beverage2.getDescription());
			System.out.println("$"+beverage2.cost());
			
			System.out.println("===================");
		}
		
	}

�������� �̿��� �θ�Ŭ����(�������̽�)Ÿ���� ���������� �ڽ�Ŭ����(�������̽�)�� �����ϵ��� �ϴ� ������  

__������ �ڵ�� �پ��� Ÿ���� ��ü�� ó���ϱ� ���ؼ���.__



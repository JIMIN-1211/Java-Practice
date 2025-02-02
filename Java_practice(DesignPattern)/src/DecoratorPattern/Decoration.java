package DecoratorPattern;

public abstract class Decoration extends Beverage {
	Beverage beverage;

	public abstract String getDescription();
	//BeverageŬ������ �Ϲ� �޼��带 �߻�޼���� �������̵�

	@Override
	public Size getSize() {
		// TODO Auto-generated method stub
		return beverage.getSize(); //���⼭�� beverage�� ���߿� ����Ŭ������ ��� �޴��� �׳� ���� �����ϰ� �ִ� beverage��ü�� ����� �������� ���� �����϶�� �ǹ��̴�. 
	}
	
}

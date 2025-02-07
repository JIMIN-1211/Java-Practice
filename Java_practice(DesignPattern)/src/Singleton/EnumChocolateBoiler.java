package Singleton;

public enum EnumChocolateBoiler {
	// 2. ����ȭ����, Ŭ���� �ε� ����, ���÷���, ����ȭ ������ȭ ���� ���� ��� �ذ� ������ enumŬ���� ���
	ENUM_INSTANCE;// == public static final ChcolateBoiler INSTANCE = new ChocolateBoiler();
	private boolean empty;
	private boolean boiled;
	
	public void fill() {
		if(isEmpty()) {
			empty = false;
			boiled = false;
		}
		System.out.println("���빰�� ä�����ϴ�. ");
	}
	
	public void drain() {
		if(!isEmpty() && isBoiled()) {
			empty = true;
		}
		System.out.println("���빰�� ������ϴ�. ");
	}
	
	public void boil() {
		if(!isEmpty() && !isBoiled()) {
			boiled = true;
		}
		System.out.println("���빰�� �������ϴ�. ");
	}
	
	public boolean isEmpty() {
		return empty;
	}
	
	public boolean isBoiled() {
		return boiled;
	}
}

package Singleton;

public class ChocolateBoiler {
	private static ChocolateBoiler instance;
	private boolean empty;
	private boolean boiled;
	
	private ChocolateBoiler() {
		this.empty = true;
	}
	//1. ���� �̱��� ������ ������� ���
	//getInstance() �޼���� ������������ �ؾ��Ѵ�. �������� �ν��Ͻ��� �ʿ��ϸ� Ŭ������ ��û�� �� �ְ� ����� ����,
	//��û�� ������ �ϳ����� �ν��Ͻ��� �ǳ��ش�. 
	public static ChocolateBoiler getInstance() {
		if(instance == null) {
			instance = new ChocolateBoiler();
		}
		return instance;
	}
	
	//-- ��Ƽ�������� ��� --
	// 1) �ӵ��� ũ�� �߿����� ���� ���
//	public static synchronized ChocolateBoiler getInstance() {
//		if(instance == null) {
//			instance = new ChocolateBoiler();
//		}
//		return instance;
//	}

	// 2) �ν��Ͻ��� �� �ʿ��� ��� �������� �ʰ� ó������ ����� �ΰ� ����
//	private static ChocolateBoiler enssentialInstance = new ChocolateBoiler();
//	public static ChocolateBoiler getInstance() {
//		return instance;
//	}
	
	// 3) �ν��Ͻ��� �� �ʿ����� ������ ������ �� ��� �Ǵ� �ӵ��� ������ϴ� ��� 
//	private volatile static ChocolateBoiler instance;
//	public static ChocolateBoiler getInstance() {
//		if(instance == null) {
//			synchronized (ChocolateBoiler.class) {
//				if(instance == null) {	
//					instance = new ChocolateBoiler();
//				}
//			}
//		}
//		return instance;
//	}	
	
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

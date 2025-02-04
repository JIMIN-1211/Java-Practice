package AbstractFactoryMethodPattern;

public abstract class Pizza {
	String name;
	
	Dough dough;
	Sauce sauce;
	Cheese cheese[];
	Veggies veggies[];
	Pepperoni pepperoni;
	Clams clam;
	
	public abstract void prepare();
	
	public void bake() {
		System.out.println("175������ 25�а� ����");
	}
	
	public void cut() {
		System.out.println("���ڸ� �缱���� �ڸ���");
	}
	
	public void box() {
		System.out.println("���ڿ� ���ڸ� ���");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}

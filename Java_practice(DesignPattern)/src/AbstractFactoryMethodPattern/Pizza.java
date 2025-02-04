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
		System.out.println("175도에서 25분간 굽기");
	}
	
	public void cut() {
		System.out.println("피자를 사선으로 자르기");
	}
	
	public void box() {
		System.out.println("상자에 피자를 담기");
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

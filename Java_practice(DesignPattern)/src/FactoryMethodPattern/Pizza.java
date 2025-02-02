package FactoryMethodPattern;

import java.util.List;
import java.util.ArrayList;

public abstract class Pizza {
	String name;
	String dough;
	String sauce;
	List<String> toppings = new ArrayList<String>();
	
	public void prepare() {
		System.out.println("�غ� �� : "+name);
		System.out.println("���츦 ������ �� ...");
		System.out.println("�ҽ��� �Ѹ��� �� ...");
		System.out.println("������ �ø��� �� ...");
		for(String topping : toppings) {
			System.out.println(topping);
		}
	}
	
	public void bake() {
		System.out.println("175������ 25�а� ����");
	}
	
	public void box() {
		System.out.println("���ڿ� ���� ���");
	}
	
	public void cut() {
		System.out.println("���ڸ� �缱���� �ڸ���");
	};
	
}

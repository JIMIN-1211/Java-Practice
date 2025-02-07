package Singleton;

public class ChocolateBoilerController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. ���� �̱��� ������ ����� ���
		ChocolateBoiler boiler1 = ChocolateBoiler.getInstance();
		
		boiler1.fill();
		boiler1.boil();
		boiler1.drain();
		
		System.out.println("------------------------------");
		
		// 2. enum Ŭ������ ����� ���
		
		EnumChocolateBoiler boiler2 = EnumChocolateBoiler.ENUM_INSTANCE;
		
		boiler2.fill();
		boiler2.boil();
		boiler2.drain();
	}

}

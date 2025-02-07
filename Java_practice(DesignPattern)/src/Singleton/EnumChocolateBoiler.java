package Singleton;

public enum EnumChocolateBoiler {
	// 2. 동기화문제, 클래스 로딩 문제, 리플렉션, 직렬화 역직렬화 문제 등을 모두 해결 가능한 enum클래스 사용
	ENUM_INSTANCE;// == public static final ChcolateBoiler INSTANCE = new ChocolateBoiler();
	private boolean empty;
	private boolean boiled;
	
	public void fill() {
		if(isEmpty()) {
			empty = false;
			boiled = false;
		}
		System.out.println("내용물을 채웠습니다. ");
	}
	
	public void drain() {
		if(!isEmpty() && isBoiled()) {
			empty = true;
		}
		System.out.println("내용물을 옯겼습니다. ");
	}
	
	public void boil() {
		if(!isEmpty() && !isBoiled()) {
			boiled = true;
		}
		System.out.println("내용물을 끓였습니다. ");
	}
	
	public boolean isEmpty() {
		return empty;
	}
	
	public boolean isBoiled() {
		return boiled;
	}
}

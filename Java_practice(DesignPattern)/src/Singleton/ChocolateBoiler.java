package Singleton;

public class ChocolateBoiler {
	private static ChocolateBoiler instance;
	private boolean empty;
	private boolean boiled;
	
	private ChocolateBoiler() {
		this.empty = true;
	}
	//1. 고전 싱글턴 패턴을 사용했을 경우
	//getInstance() 메서드는 전역접근으로 해야한다. 언제든지 인스턴스가 필요하면 클래스에 요청할 수 있게 만들어 놓고,
	//요청이 들어오면 하나뿐인 인스턴스를 건네준다. 
	public static ChocolateBoiler getInstance() {
		if(instance == null) {
			instance = new ChocolateBoiler();
		}
		return instance;
	}
	
	//-- 멀티스레딩의 경우 --
	// 1) 속도가 크게 중요하지 않은 경우
//	public static synchronized ChocolateBoiler getInstance() {
//		if(instance == null) {
//			instance = new ChocolateBoiler();
//		}
//		return instance;
//	}

	// 2) 인스턴스가 꼭 필요한 경우 생성하지 않고 처음부터 만들어 두고 리턴
//	private static ChocolateBoiler enssentialInstance = new ChocolateBoiler();
//	public static ChocolateBoiler getInstance() {
//		return instance;
//	}
	
	// 3) 인스턴스가 꼭 필요하진 않지만 쓸지도 모를 경우 또는 속도가 빨라야하는 경우 
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

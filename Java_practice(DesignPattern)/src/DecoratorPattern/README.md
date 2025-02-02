# StarBuzz Coffee
## 프로젝트 개요
원하는 음료 종류를 선택하고 토핑을 주문하면 음료를 제공하고, 계산해주는 프로그램이다. 

## 기술 스택
- Java

## 설치 및 사용법
1. 설치 방법


	```bash
	git clone https://github.com/JIMIN-1211/DecoratorPattern.git
	cd DecoratorPattern

## 주요 기능
- 원하는 음료를 주문하고, 값을 계산할 수 있다. 

## 문제 해결 과정
### 1. 상속받은 일반메서드의 추상화
토핑을 추가할 경우 토핑명을 추가하지만, 비용 계산 메서드는 그대로 사용하기 위해

Decoration 추상 클래스가 Beverage 추상클래스를 상속해서 getDescription()일반 메서드를 추상화 했다. 

	```Java
	public abstract class Decoration extends Beverage {
		Beverage beverage;
	
		public abstract String getDescription();
		//Beverage클래스의 일반 메서드를 추상메서드로 오버라이딩
		
	}

__일반 메서드는 선택적으로 오버라이딩 가능하므로, 일반 메서드를 추상화함으로써 구현을 강제하는 방식이다.__

__Why?__
- Beverage추상클래를 직속으로 상속 받은 음료 클래스의 음료명을 반환하는 getDescription()메서드를 호출해서 토핑명도 추가하는 코드로 구현하기 위해서 

### 2. 객체에 추가 요소를 동적으로 더하기
토핑을 추가할 Beverage인스턴스를 Decoration클래스의 Beverage인스턴스에 할당하는 생성자 코드를 작성한다.

__이를 통해 메서드를 호출하여 객체에게 어떤 행동을 위임하거나 추가작업을 수행하도록 한다.__

즉 토핑 요소를 추가하거나, 토핑 가격 요소를 추가하는 작업을 수행하도록 할 수 있다. 

	```Java
	public class Milk extends Decoration {
	
	public Milk(Beverage beverage) { // beverage ==> 추가하고자 하는 음료정보를 저장하고 있는 인스턴스 
		this.beverage = beverage;    // this.beverage ==> Decoration클래스의 Beverage타입 인스턴스
	}				// 토핑을 추가할 음료를 인스턴스에 할당하도록 하는 생성자
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + ", 우유";
	}//추상화했던 getDescription()메서드에서 음료의 description 객체에 '우유'토핑 요소를 동적으로 추가 가능하다.
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return beverage.cost() + .10;
	}//추상화하지 않았지만 동적으로 가격 요소를 추가하여 계산 시키는 cost()메서드로 구현

}
### 3. 다형성
	부모 클래스인 'Beverage'타입의 참조 변수인 beverage1을 자식클래스인 'Houseblend'를  참조하도록 할당하는 이유는   
	어떤 타입(음료 또는 토핑)이든지 상관 없이 Beverage를 상속하고 있는 클래스의 getDescription()메서드와 cost()메서드를 사용하기 위해서이다. 
	
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

다형성을 이용해 부모클래스(인터페이스)타입의 참조변수를 자식클래스(인터페이스)를 참조하도록 하는 이유는  

__동일한 코드로 다양한 타입의 객체를 처리하기 위해서다.__



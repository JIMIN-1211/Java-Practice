# PizzaFactory
## 프로젝트 개요
지점에 따라 스타일이 다른 피자를 제공하는 프로그램이다.

## 기술 스택
- Java

## 설치 및 사용법
1. 설치 방법


	```bash
	git clone https://github.com/JIMIN-1211/FactoryMethodPattern.git
	cd FactoryMethodPattern

## 주요 기능
- 뉴욕 스타일 피자를 주문하고 싶으면 해당 지점에서 피자를 주문하면 치즈 피자를 주문하더라도 뉴욕식 피자를 만들어서 제공해준다. 
- 시카고 스타일 피자 또한 주문이 가능하다. 

## 문제 해결 과정
### 1. 구상 클래스와 서브 클래스의 차이점
구상 클래스 : 부모 클래스의 기능만 제공하고 상속은 불가하다.   

서브 클래스 : 부모 클래스의 기능 확장 / 변경하고 상속이 가능하다. 

### 2. 팩토리 메서드
	이 코드에서 볼 때 피자 인스턴스를 생성할 경우 여러 종류의 피자 인스턴스를 생성하고 제거해야하는 경우 일일히 pizzaStore의 코드를 매번 수정해줘야한다. 
	
		```Java
		public class PizzaStore {
			public Pizza OrderPizza(String type) {
				Pizza pizza;
				
				if(type.equals("cheese"){
					pizza = new CheesePizza(); //이부분
				}else if(type.equals("pepperoni"){
					pizza = new pepperoniPizza(); //이부분
				}
			}
		}
	
	그래서 이런 변화되는 부분을 **캡슐화** 해서 객체 생성과 사용을 분리한다. 
	
	그리고 이렇게 객체 생성부분을 인터페이스 또는 추상클래스에 추상 메서드로 팩토리 메서드를 정의하고   
	이걸 상속받은 '서브클래스'에 따라 객체를 생성하는 방법을 동적으로 변경할 수 있다. 
	
		```Java
		public abstract class PizzaStore {
	
			public Pizza OrderPizza(String type) {
				Pizza pizza;
				
				pizza = CreatePizza(type);
				
				pizza.prepare();
				pizza.bake();
				pizza.cut();
				pizza.box();
				
				return pizza;
			}
			
			public abstract Pizza CreatePizza(String type);//팩토리 메서드
		
		}
		//서브클래스
		public class NyPizzaStore extends PizzaStore {
		
			@Override
			public Pizza CreatePizza(String type) {
				// TODO Auto-generated method stub
				if(type.equals("cheese")) {
					return new NyStyleCheesePizza();
				}else {
					return new NyStylePepperoniPizza();
				}
			}
		
		}
		//서브클래스
		public class ChicagoPizzaStore extends PizzaStore {
		
			@Override
			public Pizza CreatePizza(String type) {
				// TODO Auto-generated method stub
				if(type.equals("Cheese")) {
					return new ChicagoStyleCheesePizza();
				}else {
					return new ChicagoStylePepperoniPizza();
				}
			}
			
		}
		
		
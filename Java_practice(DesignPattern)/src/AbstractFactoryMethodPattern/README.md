# PizzaFactory 2.0
## 프로젝트 개요
이전 피자 팩토리 프로그램보다 구상클래스 의존도를 더 낮춰서 유연성과 확장성을 높인 피자 팩토리 프로그램이다. 

## 기술 스택
- Java

## 설치 및 사용법
1. 설치 방법


	```bash
	git clone https://github.com/JIMIN-1211/DecoratorPattern.git
	cd DecoratorPattern

## 주요 기능
- 지점별로 다른 재료를 사용하여 피자를 만들기 때문에, 각 지점별 피자의 사용된 재료를 구체적으로 보여준다.
- 지점별로 다른 같으 피자를 주문하더라도 다른 피자를 만들어 준다. 

## 문제 해결 과정
### 1. 피자 종류에 맞는 원재료군을 생산
추상 팩토리로(인터페이스 / 추상클래스) 제품군을 생성하는 인터페이스를 제공할 수 있다. 
	
	```Java
	//인터페이스 정의(객체마을 추상 원재료 공장)
	public interface PizzaIngredientFactory {
	
		public Dough createDough();					//팩토리 메서드
		public Sauce createSauce();					//팩토리 메서드
		public Cheese[] createCheese();				//팩토리 메서드
		public Veggies[] createVeggies(Veggies[] selectedVeggies);	//팩토리 메서드
		public Pepperoni createPepperoni();				//팩토리 메서드
		public Clams createClams();					//팩토리 메서드
	}
	//서브 클래스 (뉴욕지점)
	public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
	
		@Override
		public Dough createDough() {
			// TODO Auto-generated method stub
			return new ThinDough();
		}
	
		@Override
		public Sauce createSauce() {
			// TODO Auto-generated method stub
			return new MarinaraSauce();
		}
	
		@Override
		public Cheese[] createCheese() {
			// TODO Auto-generated method stub
			Cheese cheese[] = {new ReggianoCheese()};
			return cheese;
		}
	
		@Override
		public Veggies[] createVeggies(Veggies[] selectedVeggies) {
			// TODO Auto-generated method stub
			return selectedVeggies;
		}
	
		@Override
		public Pepperoni createPepperoni() {
			// TODO Auto-generated method stub
			return new SlicedPepperoni();
		}
	
		@Override
		public Clams createClams() {
			// TODO Auto-generated method stub
			return new FreshClams();
		}
	
	이렇게 함으로써 지역, 운영체제, 룩앤필 등 서로 다른 상황에 맞는 제품을 생산하는 팩토리를 구현할 수 있다. 
	
### 2. 필요한 채소재료들만 준비한다. 
피자 메뉴마다 필요로하는 채소들이 다르다 따라서, 지점별로 피자가게에서 필요한 채소들만 선택해서 피자를 만든다. 
  
처음엔 뉴욕 지점에서 사용하는 채소들을 팩토리메서드 구상클래스 즉 'NYPizzaIngredientFactory'클래스에서 생성해 놓고,   
필요한 채소들만 각 피자 메뉴별로 가져올 생각이었다.   

그러나 굳이 불필요한 모든 채소까지 반환한 다음 다시 필터링을 하는 작업은 코드의 효율성이 떨어지는 것 같아, 그냥 피자가게에서 필요한 채소만 생성하는 생성자를 주입하는 형태로 접근하였다. 

	```Java
	public interface PizzaIngredientFactory {
	
		public Dough createDough();
		public Sauce createSauce();
		public Cheese[] createCheese();
		
		public Veggies[] createVeggies(Veggies[] selectedVeggies);		//필요한 채소만 생성하는 생성자 주입하는 팩토리 메서드
		
		public Pepperoni createPepperoni();
		public Clams createClams();
	}
	//서브클래스
	public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
		@Override
		public Veggies[] createVeggies(Veggies[] selectedVeggies) {
			// TODO Auto-generated method stub
			return selectedVeggies; //필요한 채소만 생성한 Veggies타입 selectedVeggies배열 반환
		}
	}
	//피자레시피
	public class CheesePizza extends Pizza {
	
		PizzaIngredientFactory pizzaIngredientFactory;
		Veggies selectedVeggies[];
		
		public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory, Veggies selected[]) {
			this.pizzaIngredientFactory = pizzaIngredientFactory;
			this.selectedVeggies = selected;
		}
	
		@Override
		public void prepare() {
			// TODO Auto-generated method stub
			
			System.out.println("준비 중 : " + name);
			
			dough = pizzaIngredientFactory.createDough();
			sauce = pizzaIngredientFactory.createSauce();
			cheese = pizzaIngredientFactory.createCheese();
			veggies = pizzaIngredientFactory.createVeggies(selectedVeggies); //필요한 채소만 생성
			
			System.out.print("재료 : "+dough+", "+sauce);
			for(Cheese cheese : cheese) {
				System.out.print(", ");
				System.out.print(cheese);
			}
			for(Veggies veggie : veggies) {
				System.out.print(", ");
				System.out.print(veggie);	
			}
			
			System.out.println("");
			
		}
	
	}
	
마지막으로 필요한 채소를 setter로 지정할 수 있지 않나라는 생각을 해서 chatGPT에게 물어보니

불필요한 외부 의존성: setter를 사용하면 Pizza 클래스의 내부 상태(채소 등)를 외부에서 변경할 수 있게 됩니다. 이는 객체의 상태를 불안정하게 만들 수 있으며, 의도하지 않은 값이 들어갈 가능성도 존재합니다.

불완전한 객체 생성: Pizza 객체가 완전히 생성되지 않은 상태에서 외부에서 veggies를 설정한다면, 그 객체는 비정상적인 상태일 수 있습니다. 예를 들어, Pizza의 prepare() 메서드에서 veggies가 설정되기 전에 prepare()가 호출될 경우 veggies 값이 null이 될 수 있습니다.

팩토리 메서드의 장점 상실: 팩토리 메서드 패턴에서는 객체 생성 과정이 캡슐화되어야 하므로, 외부에서 setter를 통해 채소를 설정하는 방식은 구상 클래스에 의존하지 않으려는 패턴의 취지에 맞지 않습니다.

이런 이유로 오히려 더 비효율적인 코드가 될 수 있다는 결론을 내렸다. 



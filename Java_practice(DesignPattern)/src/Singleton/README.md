# ChocolateBoiler
## 프로젝트 개요
초콜릿 보일러 인스턴스 단 하나만 필요로 하는 초콜릿 보일러 프로그램이다. 

## 기술 스택
- Java

## 설치 및 사용법
1. 	이 프로젝트를 로컬로 클론하거나 다운로드합니다. 

	```bash
	git clone https://github.com/JIMIN-1211/ChocolateBoiler.git
	cd ChocolateBoiler

## 주요 기능
- 초콜릿 보일러가 비어있으면 채우고 채워져 있고, 데우지 않았으면 데우고  데워졌으면 옮기는 초콜릿 보일러 시스템이다. 

## 문제 해결 과정
### 1. 싱글턴 패턴
##### - 정의 
클래스 인스턴스를 하나만 만들고, 그 인스턴스로의 지역접근을 제공한다. 
##### - 사용방법

1) 정적 요소 인스턴스를 선언
=> static요소는 생성되는 객체의 개수에 상관 없이 딱 하나만 존재한다. 즉 하나의 인스턴스를 공유하고 있다는 말이다.    
	
	```Java
	public class Counter {
		private static int count = 0;
		
		public static Button() {
			count++;
		}
	}
	
	이 경우 Counter 인스턴스를 여러개 생성하더라도 static인스턴스이기 때문에 각 인스턴스가 count인스턴스를 여러개 생성해도   
	여러개의 인스턴스 또한 서로 공유하고 있기 때문에 count의 개수는 계속해서 오른다. 

2) 그 인스턴스로의 전역접근을 제공한다. 
=>getter로 인스턴스의 생성여부를 확인 후 인스턴스를 리턴한다. 

	```Java
	public static int getInstance() {
		if(count == null){
			count = new Counter();
		}
		return count;
	}
		
##### - 사용하는 이유

	특정 클래스에서 인스턴스를 하나만 필요로 하는겨우 예를 들면 페이지의 테마가 다크모드인지, 라이트모드인지 여부를 정하는 데이터는   
	프로그램 전체에 동일하게 적용되어야하므로 두군데 이상에 저장되면 곤란하다.   
	이와 같은 경우에 단 하나의 인스턴스만을 생성하도록 해야하는 싱글턴 패턴이 필요하다.
 
### 2. 멀티 스레드 환경에서 싱글턴 패턴이 작동할 수 있도록 하기
process : 프로그램이 실행되서 돌아가고 있는 상태 (ex. .exe프로그램이 실행되고 있는 상태)   

컴퓨터는 여러개의 프로세스를 소유하고 동시적, 병렬적으로 실행   

	1. 동시적  : 코어 하나로 컴퓨터 프로세스를 차례대로 빠르게 실행시키는데 이속도가 굉장히 빠르기 때문에 우리가 느끼기엔 동시에 돌아간다고 느낌
	2. 병렬적 : 동시적 프로세스가 과부하가 걸리기 때문에 여러개의 코어로 프로세스 동시 실행

쓰레드(thread) : 프로세스 안에서 실행되는 작업들. 프로세스 내에서 같은 메모리를 사용한다.   
__하지만!__ 쓰레드들이 동시에 같은 메모리를 수정할 경우 어느 쓰레드는 실행이 되지 않는 오류가 발생하기도한다.   
__해결법__ : 한 쓰레드가 작업을 진행할 때 다른 쓰레드에게 대기를 명령한다 ==> __synchronized__   

synchronized : 최초로 해당 메서드를 호출한 쓰레드가 종료될 때까지 다른 스레드가 접근하지 못하도록 'lock'을 건다. 

	1) getInstance()의 속도가 그리 중요하지 않은 경우
	```Java
	public static ChocolateBoiler synchronized getInstatnce() {
		if(instance == null){
			instance = new ChocolateBoiler();
		}
		return instance;
	}
	
	2) 인스턴스를 꼭 써야 하는 경우 
	```Java
	public class ChocolateBoiler {
		private static ChcolateBoiler instance = new ChocolateBoiler();
		
		public static ChocolateBoiler synchronized getInstance(){
			return instance;
		}
	}
	애플리케이션에서 싱글턴 클래스의 인스턴스를 생성하고 계속해서 사용해야하거나, 인스턴스를 실행 중에 수시로 만드로 관리하기가 성가실 경우 이 방법을 사용할 수 있다. 
	
__단점 :__ 여러개의 인스턴스 생성을 방지하기 위해 동기화 했는데, 이미 인스턴스를 생성한 뒤에는 어차피 이미 생성된 인스턴스를   
반환하기만 되기 때문에 'lock'을 걸 필요가 없다. __따라서 일을 잘 수행하지만 성능저하가(속도가 느려지는 등의) 발생한다. __

- CPU : 컴퓨터의 두뇌, 연산장치, 계산기 즉 __연산에 특화된__ 장치이다. 메모리에 저장된 값을 읽고 해석해서 실행하는 장치이다.   
- 메모리 : CPU가 연산을 하는데 있어 필요한 정보를 저장해 두는 곳. 

CPU에 모든 정보를 저장해서 바로 불러올 수 있으면 가장 이상적이겠지만, CPU는 연산에 특화된 장치이므로 가격(비용)이 꽤 비싸다.   
따라서 컴퓨터 내부에 메모리들을 배치하여 CPU가 필요할 때 데이터를 제공하는 역할을 한다.

여기서 메모리의 개념은  __하드디스크와 메인메모리, 캐시메모리, CPU레지스터__ 부분을 포함하고 있다.   

- 하드디스크 : 보조 기억장치로 전원이 꺼져도 데이터가 지워지지 않는 장기기억장치이다.   
- 메인메모리 : 메인메모리는 주기억장치로 속도가 빠르지만 전원이 꺼지면 데이터가 지워진다.   
따라서 __당장 급하게 실행해야하거나 현재 실행중인 프로그램 또는 데이터에 대한 결과를 저장__ 한다.   
그리고 하드디스크로 부터 일정 데이터를 받아 CPU가 필요로 할 때 바로바로 보내주는 역할을 한다.    
- 캐시 메모리 : 메인 메모리와 CPU의 속도차이를 보완하는 역할로서, CPU와 가장 가까이에 위치하여 빠른 속도를 자랑한다.   
- CPU 레지스터 : CPU 내부에서 컴퓨터 실행에 중추적으로 필요한 프로그램(ex.운영체제)의 데이터를 내용들을 필수적인 내용들만 저장한다.   

여러개의 쓰레드를 사용할 경우 성능을 위해서 각각의 쓰레드들은 변수를 메인메모리가 아닌 캐시메모리에서 가져온다.   
따라서 각 쓰레드마다 할당되어 있는 캐쉬메모리의 변수값이 일치하지 않을 수 있다는 문제점이 발생한다. 

- volatile : 변수를 선언할 때 앞에 붙이면 컴파일러가 해당변수를 최적화에서 제외하여 메모리에 접근하여 참조하도록 한다.   

따라서 인스턴스 변수를 선언할 때 volatile키워드를 추가하여 선언한다. 

	3) DCL(Double-Check-Locking) 방식을 통해 인스턴스를 생성할 때만 동기화 하기
	
	```Java
	public class ChocolateBoiler{
		//같은 메인메모리의 변수값을 참조하도록 volatile키워드 사용
		private volatile static ChocolateBoiler instance = new ChocolateBoiler();
		
		public static ChocolateBoiler getInstance() {
			if(instance == null){
				//인스턴스가 생성되지 않았을 때만 즉 생성해야만 할 때만 동기화('lock') 한다. 
				synchronized(ChocolateBoiler.class){
					if(instance == null){
						instance = new ChocolateBoiler();
					}
				}
			}
			return instance;
		}
	}
	
<img src="https://velog.velcdn.com/images/kssumin/post/07f30fef-108f-43f9-8c4c-7474799950ae/image.png" width="400px"></img>

<img src="https://velog.velcdn.com/images/kssumin/post/038b2556-a505-4f4f-9780-005dc1022b05/image.png" width="400px"></img>

### 3. LazyHolder(중첩클래스)
JVM은 클래스를 로딩할 때 static inner class는 바로 생성하지 않는다.   
즉 싱글턴 클래스에 중첩하여 정적 클래스를 만든다. 이때 이 중첩 클래스는 인스턴스를 생성하는 클래스로   
인스턴스 생성이 필요할 때로 인스턴스 초기화(생성)을 미룬다. 

	```Java
	public class Singleton { 
		
		private Singleton(){}//싱글턴 인스턴스 생성을 private으로 접근제한
		
		public static Singleton getInstance() { //하나의 인스턴스를 가져올 메서드
			return LazyHolder.INSTANCE;
		}
		
		private class LazyHolder {
			private static final Singleton INSTANCE = new Singleton();
		}
		
	} 
	
 __성능이 중요시 되는 환경의경우 LazyHolder방식을 이용해서 싱글턴을 구현할 수 있다. __

### 4. Enum
stack 영역 : 메서드내에서 정의하는 기본 자료형 즉 int, double , boolean, long, byte등에 해당하는 지역변수의 데이터 값이 저장되는 공간이다. 그리고 object타입의 데이터의 __참조값__ 을 저장한다.
heap 영역 : string과 같은 object타입의 __데이터__ 가 저장되는 공간이다.   

stack은 함수가 호출될 때 사용하는 메모리이고, 기능 수행이 끝나면 메모리는 해제된다.   
heap은 자동으로 관리가 되지 않기 때문에 JVM의 가비지 컬렉터가 주기적으로 메모리 정리를 실행해준다. 

enum : 열거형 즉 서로 연관된 상수들의 집합이면서 일종의 클래스로 쓰인다. 따라서 생성자와 메서드도 가질 수 있다.   

enum은 고정된 상수들의 집합이므로 런타임(실행되고 있는 시점)이 아닌 '컴파일 시점'(컴파일하는 시점)에 모든 값을 알고 있어야 한다.   
즉 생성자가 private으로 제한된다. --> 컴파일 하는 시점에서 이미 모든 값이 고정되어 있어야 하므로 생성자를 접근할 수 없도록 private으로 제한     

	```Java
	public enum EnumChocolateBoiler {
	
		// 2. 동기화문제, 클래스 로딩 문제, 리플렉션, 직렬화 역직렬화 문제 등을 모두 해결 가능한 enum클래스 사용
		ENUM_INSTANCE; // == public static final ChcolateBoiler ENUM_INSTANCE = new ChocolateBoiler();
		private boolean empty;
		private boolean boiled;
		
		//보일러 메서드 코드
		
	}
	
 __Enum 을 이용한 싱글톤 구현은 직렬화, 안정성을 중시 되는 환경에서 쓰인다. __

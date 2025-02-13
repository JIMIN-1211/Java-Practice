# WeatherStaition
## 프로젝트 개요
자바의 옵저버 패턴을 이용해서 온도,습도,기압의 상태가 바뀌면 자동으로 기상관측 내용이 갱신되는 프로젝트이다. 

## 기술 스택
- Java

## 설치 및 사용법
1. 	이 프로젝트를 로컬로 클론하거나 다운로드합니다. 

	```bash
	git clone https://github.com/JIMIN-1211/WeatherApp.git
	cd WeatherApp

## 주요 기능
- 현재 날씨 상태, 기상 통계, 기상 예보를 보여 주는 3가지 디스플레이의 정보가 바뀔 때마다 자동으로 업데이트되도록 해준다. 
- 원하는 기상 디스플레이가 있을 경우 추가할 수 있다. 

## 문제 해결 과정
### 1. List인터페이스 타입으로 된 observers객체를 선언하는 이유   
  - 어차피 ArraList타입의 구현체로 할당할 것이면 왜 굳이 List인터페이스 타입으로 객체를 선언하는지 이해하지 못했음. 
	
	- List인터페이스 타입으로 선언한 뒤 ArrayList 구현체로 할당하면 나중에 다른 구현체 타입(ex. LinkedList)으로의 재할당이 가능하다. 
	- 하지만 처음부터 객체를 구현체인 클래스 타입 ArrayList로 객체를 선언하게 되면 그 객체의 타입이 고정되므로 나중에 재할당이 불가능해진다. 
	- __따라서 유연성을 위해서 List타입으로 선언하는 것이 더 좋다.__

### 2. float와 double형의 차이점   
  - float와 double형은 둘다 실수를 나타내는데 왜 다르게 쓰일까 단순히 메모리 사용량 때문일까 고민했다. 
	
	- 크기 
	 float : 4바이트, 	double : 8바이트
	- 소수점 정밀도 
	 float : 약 7자리 , 	double : 약 15~16자리 
	- 기본값
	 float : 0.0f, 		double : 0.0
 
	__이렇게 float와 double의 차이는   
	메모리 절약이 필요한 경우 float,   
	정밀한 계산이 필요한 경우 double로 정리할 수 있다.__

### 3. 옵저버 패턴   
  - 한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체에게 연락이 가고 자동으로 내용이 갱신되는 방식으로 (1 : n)일대다 의존성을 갖는다. 
	
	이때 일대다 의존성은 Subject(주제 객체 : 중요한 데이터를 관리하는 객체)는 '유튜버'이고, ==> '1'   
	Observer(옵저버 객체 : 주제 데이터가 바뀌면 갱신 내용을 전달 받는 객체)는 '구독자'이다. ==> 'n'

### 4. pull방식   

	처음에 프로그램을 작성할 때에는 update()추상메서드를 정의할 때, 
	
	```java
	public void update(float temp, float humidity, float pressure);
	
	이렇게 정의했었는데 각 display 클래스 별로 필요로 하는 기상데이터들이 달랐다.
	그리고 display를 호출할 때마다 불필요한 데이터까지 가져올 필요는 없으므로  
	 
	풀(pull)방식으로 내가 필요한 데이터만 가져오는 getter메서드를 구현하여 프로그램을 완성했다. 



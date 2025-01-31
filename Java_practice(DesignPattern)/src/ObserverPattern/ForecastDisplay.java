package ObserverPattern;

public class ForecastDisplay implements Observer, Display {
	private float currentPressure = 29.79f;
	private float lastPressure;
	private WeatherData weatherData;
	
	public ForecastDisplay(WeatherData weatherdata) {
		// TODO Auto-generated constructor stub
		this.weatherData = weatherdata;
		weatherdata.registerObserver(this);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.print("��� ���� : ");
		if(lastPressure > currentPressure) {
			System.out.println("������ �������� �ֽ��ϴ�. ");
		}else if(lastPressure < currentPressure) { 
			System.out.println("������ �ҽ��ϸ�, �� �� �� �����ϴ�. ");
		}else {
			System.out.println("���ݰ� ���� �� �����ϴ�. ");
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		lastPressure = currentPressure;
		currentPressure = weatherData.getPressureData();
		display();
	}

}

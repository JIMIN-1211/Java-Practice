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
		System.out.print("기상 예보 : ");
		if(lastPressure > currentPressure) {
			System.out.println("날씨가 좋아지고 있습니다. ");
		}else if(lastPressure < currentPressure) { 
			System.out.println("날씨가 쌀쌀하며, 비가 올 것 같습니다. ");
		}else {
			System.out.println("지금과 같을 것 같습니다. ");
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

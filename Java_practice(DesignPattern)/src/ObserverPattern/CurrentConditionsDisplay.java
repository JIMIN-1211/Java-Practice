package ObserverPattern;

public class CurrentConditionsDisplay implements Observer, Display {
	private float temperature;
	private float humidity;
	private WeatherData weatherData;
	
	public CurrentConditionsDisplay(WeatherData weatherdata) {
		// TODO Auto-generated constructor stub
		this.weatherData = weatherdata;
		weatherdata.registerObserver(this);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub\
		System.out.println("현재 상태 : " + "온도 " + temperature + "F, " + humidity + "%");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		temperature = weatherData.getTempData();
		humidity = weatherData.getHumidityData();
		display();
	}

}

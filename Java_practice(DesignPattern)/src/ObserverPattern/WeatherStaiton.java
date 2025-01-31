package ObserverPattern;

public class WeatherStaiton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeatherData weatherStation = new WeatherData();
		
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherStation);
		StatictsDisplay statictsDisplay = new StatictsDisplay(weatherStation);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherStation);
		
		weatherStation.setMeasurements(80, 65, 30.4f);
		System.out.println("======================================");
		weatherStation.setMeasurements(82, 70, 29.2f);
		System.out.println("======================================");
		weatherStation.setMeasurements(78, 90, 29.2f);
		System.out.println("======================================");
	}

}

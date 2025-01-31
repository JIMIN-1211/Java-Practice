package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
	private float tempData;
	private float humidityData;
	private float pressureData;
	private List<Observer> observers;
	
	public WeatherData() {
		observers = new ArrayList<Observer>();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.remove(o);
	}

	@Override
	public void measurementsChanged() {
		// TODO Auto-generated method stub
		for(Observer observer : observers ) {
			observer.update();
		}
	}
	
	public void notifyObservers() {
		measurementsChanged();
	}
	
	public void setMeasurements(float temp, float humidity, float pressure) {
		this.tempData = temp;
		this.humidityData = humidity;
		this.pressureData = pressure;
		notifyObservers();
	}

	public float getTempData() {
		return tempData;
	}

	public float getHumidityData() {
		return humidityData;
	}

	public float getPressureData() {
		return pressureData;
	}
	

}

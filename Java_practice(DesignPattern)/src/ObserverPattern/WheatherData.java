package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class WheatherData implements Subject {
	private List<Observer> observers;
	private float temp;
	private float humidity;
	private float pressure;
	
	public WheatherData() {
		// TODO Auto-generated constructor stub
		observers = new ArrayList<Observer>();
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
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for(Observer observer : observers) {
			observer.update(temp, humidity, pressure);
		}
	}
	
	public void measurementsChanged() {
		notifyObserver();
	}
	
	public void setMeausrements(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

}

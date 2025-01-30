package ObserverPattern;

public class CurrentConditionsDisplay implements Observer, Display {
	private float temperature;
	private float humidity;
	private float pressure;
	private WheatherData wheatherData;
	
	public CurrentConditionsDisplay(WheatherData wheatherdata) {
		// TODO Auto-generated constructor stub
		this.wheatherData = wheatherdata; 
		wheatherData.registerObserver(this);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float temp, float humdity, float pressure) {
		// TODO Auto-generated method stub

	}

}

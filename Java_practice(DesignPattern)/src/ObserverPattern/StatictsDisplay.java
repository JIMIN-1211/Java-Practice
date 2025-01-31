package ObserverPattern;

public class StatictsDisplay implements Display, Observer {
	private float temperature;
	private float avg, min, max; //���, ���� , �ְ�
	private float totalTemperature = 0;
	private int count = 0;
	private WeatherData weatherData;
	
	public StatictsDisplay(WeatherData weatherdata) {
		this.weatherData = weatherdata;
		weatherdata.registerObserver(this);
	}
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		count++;
		temperature = weatherData.getTempData();
		totalTemperature += temperature;
		if(count == 1) {
			min = temperature;
			max = temperature;
		}else {
			if(temperature < min) {
				min = temperature;
			}else if(temperature > max) {
				max = temperature;
			}
		}
		avg = totalTemperature/count;
		display();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("��� / �ְ� / ���� �µ� : " + avg + " / " + max + " / " + min);
	}

}

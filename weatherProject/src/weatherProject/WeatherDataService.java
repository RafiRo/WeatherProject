package weatherProject;

public class WeatherDataService implements IWeatherDataService {
	WeatherData weatherData;
	int picture;
	String type;
	public WeatherDataService() {
		weatherData= new WeatherData();
	}

	@Override
	public double KelvinTCelsiusConversion(double kelvin){
		return kelvin-273.15;
	}

	@Override
	public double KelvinToFahrenheitConversion(double kelvin){
		return( (kelvin-273.15)*9/5)+32;
	}

	@Override
	public int temperatureToPictureConversion(double kelvin){
		if (kelvin<278.15)
			return 1 ;//snow
		else if (kelvin>278.16 && kelvin<292.15)
			return 2;//rain
		else
			return 3;//sun
	}

	@Override
	public void getWeatherData(Location location,String type) {
		this.type=type;
		weatherData = weatherData.getInstance(location);
		if (weatherData.getLocation().getCity()==null)
		{
			picture=0;	
		}
		else 
		{
			picture=temperatureToPictureConversion(weatherData.getTemearture());	
			if (type=="C")
				weatherData.setTemperature(KelvinTCelsiusConversion(weatherData.getTemearture()));
			else if (type=="F")
				weatherData.setTemperature(KelvinToFahrenheitConversion(weatherData.getTemearture()));	
		}
	}
}

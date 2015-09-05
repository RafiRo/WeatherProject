package weatherProject;

public interface IWeatherDataService {
	public void getWeatherData(Location location, String type) throws WeatherDataServiceException;	
	public double KelvinTCelsiusConversion(double kelvin);
	public double KelvinToFahrenheitConversion(double kelvin);
	public int temperatureToPictureConversion(double kelvin);
}
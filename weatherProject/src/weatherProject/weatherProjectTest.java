package weatherProject;
import org.junit.Test;
import org.junit.Assert;

public class weatherProjectTest {

	@Test
	public void KelvinTCelsiusConversionTest() {
		double kelvin;
		kelvin= new WeatherDataService().KelvinTCelsiusConversion(100);
		Assert.assertEquals(-173.15, kelvin, 0.001);	
	}

	@Test
	public void KelvinToFahrenheitConversionTest() {
		double kelvin;
		kelvin= new WeatherDataService().KelvinToFahrenheitConversion(100);
		Assert.assertEquals(-279.67, kelvin, 0.001);
	}


	@Test
	public void decodeJsonDataTest()
	{
		Double temp;
		String test ="{\"coord\":{\"lon\":34.99,\"lat\":32.82},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"Sky is Clear\",\"icon\":\"01d\"}],\"base\":\"cmc stations\",\"main\":{\"temp\":305.15,\"pressure\":1010,\"humidity\":35,\"temp_min\":305.15,\"temp_max\":305.15},\"wind\":{\"speed\":3.6,\"deg\":310},\"clouds\":{\"all\":0},\"dt\":1441291800,\"sys\":{\"type\":3,\"id\":5917,\"message\":0.0092,\"country\":\"IL\",\"sunrise\":1441250162,\"sunset\":1441296126},\"id\":294801,\"name\":\"Haifa\",\"cod\":200}";
		WeatherData wd= new WeatherData();
		try {
			wd.decodeJsonData(test);
		} catch (WeatherDataServiceException e) {
			e.printStackTrace();
		}
		temp =wd.getTemearture();
		double val=305.15;
		Assert.assertEquals(temp, val,0.1);
	}

	@Test
	public void getJsonDataTest()
	{
		String city;
		String countery;
		Location loc= new Location();
		loc.setData("IL", "Haifa");
		WeatherData wd= new WeatherData();
		try {
			wd.getJsonData(loc);
		} catch (WeatherDataServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		city= wd.getLocation().getCity();
		countery=wd.getLocation().getCountry();
		Assert.assertEquals(city, loc.getCity());
		Assert.assertEquals(countery, loc.getCountry());
	}
}

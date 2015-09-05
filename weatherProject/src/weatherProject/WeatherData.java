package weatherProject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.*;

public  class WeatherData {
	private Location location =new Location();
	private double temperature;
	private static WeatherData instance = null;

	public WeatherData() {
		this.clearWeatherData();
	}

	private WeatherData(Location location) throws WeatherDataServiceException {

		if (location.getCity().length()==0)
			throw new WeatherDataServiceException(location);
		else
			this.getJsonData(location);
	}

	protected void getJsonData(Location location) throws WeatherDataServiceException {
		StringBuilder sb = new StringBuilder();
		try {
			URLConnection connection = new URL("http://api.openweathermap.org/data/2.5/weather?q="+location.getData()).openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			in.close();
		} catch (IOException e) {
		}
		this.decodeJsonData(sb.toString());
		if (!location.compareTo(this.location))
			throw new WeatherDataServiceException(location);
	}

	protected void decodeJsonData(String json) throws WeatherDataServiceException{
		JSONObject obj = new JSONObject(json);
		if (!json.contains("\"main\""))
			throw new WeatherDataServiceException();
		else
		{
			double tempJson =obj.getJSONObject("main").getDouble("temp");
			String countryJson=obj.getJSONObject("sys").getString("country");
			String cityJson =obj.getString("name");
			this.location.setData(countryJson, cityJson);	
			this.temperature=tempJson;
		}
	}

	@Override
	public String toString() {
		return "location\n" + location + "\nTemperature:" + temperature;
	}	

	public double getTemearture(){
		return this.temperature;
	}

	public void clearWeatherData(){
		this.location= new Location(null, null);
		this.temperature = 0;
	}

	public Location getLocation(){
		return this.location;
	}
	public void setLocation(Location location){
		this.location=location;
	}

	public WeatherData getInstance(Location location){
		try {
			instance= new WeatherData(location);
			return instance;
		}
		catch (WeatherDataServiceException e) {
			e.printStackTrace();
			return   instance=new WeatherData();
		}
	}

	public void setTemperature(double temperature){
		this.temperature=temperature;
	}
}

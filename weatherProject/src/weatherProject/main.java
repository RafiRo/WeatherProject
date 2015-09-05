package weatherProject;

public class main {

	public static void main(String[] args) {
		weatherView theView = new weatherView();
		WeatherDataService theModel = new WeatherDataService();
		WeatherController theController = new WeatherController(theView, theModel);
	}
}